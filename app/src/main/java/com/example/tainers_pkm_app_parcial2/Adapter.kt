package com.example.tainers_pkm_app_parcial2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class Adapter(private val trainers: List<Result>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nombreEntrenador: TextView = view.findViewById(R.id.nameTrainer)
        private val fotoEntrenador: ImageView = view.findViewById(R.id.photoTrainer)

        fun bind(result: Result) {
            Picasso.get().load(result.picture.thumbnail).into(fotoEntrenador)
            nombreEntrenador.text = result.name.title.toString() + ". "+ result.name.first.toString()+ " " + result.name.last.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list_trainer, parent, false))
    }


    override fun getItemCount(): Int {
        return trainers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trainer = trainers[position]
        holder.bind(trainer)
    }
}
