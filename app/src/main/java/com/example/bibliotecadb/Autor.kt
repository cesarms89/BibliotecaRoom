package com.example.bibliotecadb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Autor(
    @PrimaryKey val autor_name: String,
    val nacimiento: Int,
    val nacionalidad: String,
    val genero_literario: String,
    val imagen: Int
)
