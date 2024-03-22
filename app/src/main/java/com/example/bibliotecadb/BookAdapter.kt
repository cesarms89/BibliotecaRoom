package com.example.bibliotecadb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val booksList: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){
        var bookName: TextView = itemView.findViewById(R.id.bookNombre)
        var bookImage: ImageView = itemView.findViewById(R.id.bookPhoto)
        var bookCardView: CardView = itemView.findViewById(R.id.bookCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(v)
    }

    override fun getItemCount(): Int {
        return booksList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bookName.text = booksList[position].libro
        holder.bookImage.setImageResource(booksList[position].portada)

        val cont = holder.bookCardView.context
        holder.bookCardView.setOnClickListener{
            Toast.makeText(cont, "I'm ${booksList[position].libro}", Toast.LENGTH_SHORT).show()

            // Open second activity
            val intent = Intent(cont, BookDetailActivity::class.java)
            intent.putExtra(BooksActivity.BOOK_NAME, booksList[position].libro)
            cont.startActivity(intent)
        }
    }

}