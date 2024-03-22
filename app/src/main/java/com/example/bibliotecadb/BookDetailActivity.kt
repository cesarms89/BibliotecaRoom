package com.example.bibliotecadb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val bookName = intent.getStringExtra(BooksActivity.BOOK_NAME)

        val booksDetailBackArrow: ImageView = findViewById(R.id.booksDetailBackArrow)
        booksDetailBackArrow.setOnClickListener{
            finish()
        }

        val bookDetailImage: ImageView = findViewById(R.id.bookDetailImage)
        val bookDetailTitle: TextView = findViewById(R.id.bookDetailTitle)
        val bookDetailDescription: TextView = findViewById(R.id.bookDetailDescription)

        val db = BibliotecaDB.getDatabase(applicationContext)

        lifecycleScope.launch {
            val book: Book = db.bookDao().getByName(bookName.toString())
            bookDetailImage.setImageResource(book.portada)
            bookDetailTitle.setText(book.libro)
            bookDetailDescription.setText(book.descripcion)
        }


    }
}