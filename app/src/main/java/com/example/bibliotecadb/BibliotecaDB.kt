package com.example.bibliotecadb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Autor::class, Book::class], version = 1)
abstract class BibliotecaDB: RoomDatabase() {
    abstract fun autorDao(): AutorDao
    abstract fun bookDao(): BookDao

    companion object {
        private var INSTANCE: BibliotecaDB? = null
        fun getDatabase(context: Context): BibliotecaDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,BibliotecaDB::class.java, "biblioteca")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}