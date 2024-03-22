package com.example.bibliotecadb

class InitAutors {

    suspend fun AddAutors(autorDao: AutorDao) {
        println("Writting Autors Beggin")
        autorDao.addAutor(Autor("Gabriel García Márquez", 1927, "Colombia", "Realismo mágico", R.drawable.garcia_marquez))
        autorDao.addAutor(Autor("Mario Vargas Llosa", 1936, "Perú", "Realismo", R.drawable.mario_vargas_llosa))
        autorDao.addAutor(Autor("Jorge Luis Borges", 1899, "Argentina", "Ficción, Poesía", R.drawable.jorge_luis_borges))
        autorDao.addAutor(Autor("Julio Cortázar", 1914, "Argentina", "Realismo mágico", R.drawable.julio_cortazar))
        autorDao.addAutor(Autor("Isabel Allende", 1942, "Perú", "Realismo mágico", R.drawable.isabel_allende))
        autorDao.addAutor(Autor("Carlos Ruiz Zafón", 1964, "España", "Ficción", R.drawable.ruiz_zafon))
        autorDao.addAutor(Autor("Laura Restrepo", 1950, "Colombia", "Novela histórica", R.drawable.laura_restrepo))
        autorDao.addAutor(Autor("Gioconda Belli", 1948, "Nicaragua", "Poesía, Novela", R.drawable.gioconda_belli))
        autorDao.addAutor(Autor("José Saramago", 1922, "Portugal", "Realismo mágico", R.drawable.jose_saramago))
        autorDao.addAutor(Autor("Javier Marías", 1951, "España", "Novela", R.drawable.javier_marias))
        println("Writting Autors Finished")
    }

}