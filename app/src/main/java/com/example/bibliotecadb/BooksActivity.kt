package com.example.bibliotecadb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.widget.EditText
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

        var activeSearch = false

        val autorName = intent.getStringExtra(MainActivity.AUTOR_NAME).toString()

        val booksBackArrow: ImageView = findViewById(R.id.booksBackArrow)
        booksBackArrow.setOnClickListener{
            finish()
        }

        val autorBooks: TextView = findViewById(R.id.autorBooks)
        autorBooks.setText(autorName)

        val txtBookSearch: EditText = findViewById(R.id.txtBookSearch)

        val db = BibliotecaDB.getDatabase(applicationContext)

        val recyclerView = findViewById<RecyclerView>(R.id.booksRecyclerView)
        recyclerView.setHasFixedSize(true)

        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager

        lifecycleScope.launch {
            val books = db.bookDao().getByAutor(autorName)
            val adapter = BookAdapter(books)
            recyclerView.adapter = adapter
        }

        val booksSearch: ImageView = findViewById(R.id.booksSearch)
        booksSearch.setOnClickListener{
            if (!activeSearch){
                txtBookSearch.visibility = View.VISIBLE
                txtBookSearch.requestFocus()
                activeSearch = true
            }
            else{
                val textSearch: String = txtBookSearch.text.toString()
                //println(textSearch)

                lifecycleScope.launch{
                    val books = db.bookDao().findBook(autorName, textSearch)
                    val adapter = BookAdapter(books)
                    recyclerView.adapter = adapter
                }

            }
        }
    }

    companion object {
        val BOOK_NAME: String = "BOOK_NAME"
    }

}