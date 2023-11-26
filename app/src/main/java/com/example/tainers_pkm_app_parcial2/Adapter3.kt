package com.example.tainers_pkm_app_parcial2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class Adapter3(private val fruticas: List<Fruit>) : RecyclerView.Adapter<Adapter3.ViewHolder>() {


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val nombreFruta: TextView = view.findViewById(R.id.nameFruit)
        private val fotoFruta: ImageView = view.findViewById(R.id.photoFruit)
        private val detalleFruta: TextView = view.findViewById(R.id.detailFruit)


        fun bind(frutica: Fruit) {

            nombreFruta.text = frutica.name.toString()
            detalleFruta.text = "Detalle de nutrientes que han curado a tu pokemon:\n" + " Calorías: " + frutica.nutritions.calories.toString() + "\n Carbohidratos: "+ frutica.nutritions.carbohydrates.toString() + "\n Proteínas: " + frutica.nutritions.protein.toString() + "\n Grasas: " + frutica.nutritions.fat.toString()

            val elegirImagenFruta = when(frutica.name){
                "Strawberry" -> "https://img.pokemondb.net/sprites/items/cheri-berry.png"
                "Banana" -> "https://img.pokemondb.net/sprites/items/golden-nanab-berry.png"
                "Tomato" -> "https://img.pokemondb.net/sprites/items/tamato-berry.png"
                "Pineapple" -> "https://img.pokemondb.net/sprites/items/golden-pinap-berry.png"
                "Passionfruit" -> "https://img.pokemondb.net/sprites/items/haban-berry.png"
                "Orange" -> "https://img.pokemondb.net/sprites/items/apicot-berry.png"
                "Raspberry" -> "https://img.pokemondb.net/sprites/items/figy-berry.png"
                "Papaya" -> "https://img.pokemondb.net/sprites/items/payapa-berry.png"
                "Pitahaya" -> "https://img.pokemondb.net/sprites/items/liechi-berry.png"
                "Dragonfruit" -> "https://img.pokemondb.net/sprites/items/durin-berry.png"

                else -> "https://img.pokemondb.net/sprites/items/yache-berry.png"
            }

            Picasso.get().load(elegirImagenFruta).into(fotoFruta)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list_fuit, parent, false))
    }

    override fun getItemCount(): Int {
        return fruticas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val frutita = fruticas[position]
        holder.bind(frutita)
    }
}
