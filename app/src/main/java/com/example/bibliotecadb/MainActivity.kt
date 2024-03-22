package com.example.bibliotecadb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = BibliotecaDB.getDatabase(applicationContext)

        val recyclerView = findViewById<RecyclerView>(R.id.autorRecyclerView)
        recyclerView.setHasFixedSize(false)

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        lifecycleScope.launch {
            //InitAutors().AddAutors(db.autorDao())
            //InitBooks().AddBooks(db.bookDao())

            val autores = db.autorDao().getAll()
            val adapter = AutorAdapter(autores)
            recyclerView.adapter = adapter
        }


    }

    companion object {
        val AUTOR_NAME: String = "AUTOR_NAME"
    }
}