package com.example.bibliotecadb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.launch

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val autorName = intent.getStringExtra(MainActivity.AUTOR_NAME)

        val booksBackArrow: ImageView = findViewById(R.id.booksBackArrow)
        booksBackArrow.setOnClickListener{
            finish()
        }

        val autorBooks: TextView = findViewById(R.id.autorBooks)
        autorBooks.setText(autorName)

        val db = BibliotecaDB.getDatabase(applicationContext)

        val recyclerView = findViewById<RecyclerView>(R.id.booksRecyclerView)
        recyclerView.setHasFixedSize(true)

        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager

        lifecycleScope.launch {
            val books = db.bookDao().getByAutor(autorName.toString())
            val adapter = BookAdapter(books)
            recyclerView.adapter = adapter
        }


    }

    companion object {
        val BOOK_NAME: String = "BOOK_NAME"
    }

}