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

class AutorAdapter(private val autores: List<Autor>) : RecyclerView.Adapter<AutorAdapter.AutorViewHolder>() {

    class AutorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var autorName: TextView = itemView.findViewById(R.id.autorNombre)
        var autorNacimiento: TextView = itemView.findViewById(R.id.autorNacimiento)
        var autorPais: TextView = itemView.findViewById(R.id.autorPais)
        var autorGenero: TextView = itemView.findViewById(R.id.autorGenero)
        var autorPhoto: ImageView = itemView.findViewById(R.id.autorPhoto)
        var autorCardView: CardView = itemView.findViewById(R.id.autorCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutorViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_autor, parent, false)
        return AutorViewHolder(v)
    }

    override fun getItemCount(): Int {
        return autores.size
    }

    override fun onBindViewHolder(holder: AutorViewHolder, position: Int) {
        holder.autorName.text = autores[position].autor_name
        holder.autorNacimiento.text =  "Nacido en ${autores[position].nacimiento}"
        holder.autorPais.text = autores[position].nacionalidad
        holder.autorGenero.text = autores[position].genero_literario
        holder.autorPhoto.setImageResource(autores[position].imagen)

        val cont = holder.autorCardView.context
        holder.autorCardView.setOnClickListener{
            Toast.makeText(cont, "I'm ${autores[position].autor_name}", Toast.LENGTH_SHORT).show()

            // Open second activity
            val intent = Intent(cont, BooksActivity::class.java)
            intent.putExtra(MainActivity.AUTOR_NAME, autores[position].autor_name)
            cont.startActivity(intent)

        }
    }

}