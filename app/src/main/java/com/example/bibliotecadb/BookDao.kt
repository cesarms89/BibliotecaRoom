package com.example.bibliotecadb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {

    @Query("SELECT * FROM book")
    suspend fun getAll(): List<Book>

    @Query("SELECT * FROM book WHERE autor=:autor")
    suspend fun getByAutor(autor: String): List<Book>

    @Query("SELECT * FROM book WHERE libro=:libro")
    suspend fun getByName(libro: String): Book

    @Query("SELECT * FROM book WHERE autor=:autor and libro LIKE '%' || :libro || '%'")
    suspend fun findBook(autor: String, libro: String): List<Book>

    @Insert
    suspend fun addBook(vararg book: Book)

}