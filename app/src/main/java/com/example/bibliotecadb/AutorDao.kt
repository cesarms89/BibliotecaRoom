package com.example.bibliotecadb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AutorDao {

    @Query("SELECT * FROM autor")
    suspend fun getAll(): List<Autor>

    @Insert
    suspend fun addAutor(vararg autor: Autor)

}