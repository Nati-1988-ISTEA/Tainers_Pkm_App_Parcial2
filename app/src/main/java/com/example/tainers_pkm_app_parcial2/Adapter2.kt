package com.example.tainers_pkm_app_parcial2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class Adapter2(private val pokemones: List<Pokemon>) : RecyclerView.Adapter<Adapter2.ViewHolder>() {

    lateinit var onItemClickListener: (Pokemon) -> Unit
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val nombrePokemon: TextView = view.findViewById(R.id.namePokemon)
        private val fotoPokemon: ImageView = view.findViewById(R.id.photoPokemon)
        private val tipoPokemon: TextView = view.findViewById(R.id.typePokemon)
        private val generoPokemon: TextView = view.findViewById(R.id.genderPokemon)
        private val numeroPokemon: TextView = view.findViewById(R.id.numberPokemon)

        fun bind(pokemon: Pokemon) {
            val elegirShiny = when(pokemon.id.toInt()% 3){
                0 -> "Shiny"
                else -> "No"
            }
            if(elegirShiny == "Shiny"){
                Picasso.get().load(pokemon.sprites.front_shiny).into(fotoPokemon)
            }
            else{
                Picasso.get().load(pokemon.sprites.front_default).into(fotoPokemon)
            }

            nombrePokemon.text = pokemon.name.toString()

            val typesText = "Tipo: " + pokemon.types.joinToString(", ") { it.type.name }
            tipoPokemon.text = typesText

            numeroPokemon.text = "Número: " + pokemon.id.toString()

            val elegirGenero = when(pokemon.id.toInt()% 2){
                0 -> "Female"
                else -> "Male"
            }

            generoPokemon.text = "Género: " + elegirGenero


            view.setOnClickListener{
                onItemClickListener(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list_pokemon, parent, false))
    }

    override fun getItemCount(): Int {
        return pokemones.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trainer = pokemones[position]
        holder.bind(trainer)
    }
}
