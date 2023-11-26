package com.example.tainers_pkm_app_parcial2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class Adapter(private val trainers: List<Result>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    lateinit var onItemClickListener: (Result) -> Unit
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val nombreEntrenador: TextView = view.findViewById(R.id.nameTrainer)
        private val fotoEntrenador: ImageView = view.findViewById(R.id.photoTrainer)
        private val paisEntrenador: TextView = view.findViewById(R.id.nationTrainer)
        private val generoEntrenador: TextView = view.findViewById(R.id.genderTrainer)
        private val edadEntrenador: TextView = view.findViewById(R.id.ageTrainer)

        fun bind(result: Result) {
            Picasso.get().load(result.picture.large).into(fotoEntrenador)
            nombreEntrenador.text = result.name.title.toString() + ". "+ result.name.first.toString()+ " " + result.name.last.toString()
            paisEntrenador.text = "Country: " + result.location.country.toString()
            generoEntrenador.text = "Gender: " + result.gender.toString()
            edadEntrenador.text ="Age: " + result.dob.age.toString()

            view.setOnClickListener{
                onItemClickListener(result)

            }
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
