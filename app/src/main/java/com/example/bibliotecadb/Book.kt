package com.example.bibliotecadb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    val autor: String,
    @PrimaryKey val libro: String,
    val paginas: Int,
    val descripcion: String,
    val portada: Int
)
