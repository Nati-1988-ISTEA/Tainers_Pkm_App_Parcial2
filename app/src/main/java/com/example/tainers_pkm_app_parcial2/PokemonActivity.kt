package com.example.tainers_pkm_app_parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class PokemonActivity : AppCompatActivity() {

    private lateinit var recyclerViewFruit: RecyclerView
    private lateinit var nombrePokemonTA: TextView
    private lateinit var fotoPokemonTA: ImageView
    private lateinit var tipoPokemonTA: TextView
    private lateinit var generoPokemonTA: TextView
    private lateinit var numeroPokemonTA: TextView
    private lateinit var adapter3: Adapter3
    private var listadoDeFrutas = mutableListOf<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        val pokemonElegido = intent.getParcelableExtra<Pokemon>("pokemon")

        nombrePokemonTA = findViewById(R.id.namePokemonAct)
        nombrePokemonTA.text = pokemonElegido?.name.toString()


        fotoPokemonTA = findViewById(R.id.photoPokemonAct)


        val elegirShiny = when(pokemonElegido?.id?.toInt()?.rem(3)){
            0 -> "Shiny"
            else -> "No"
        }
        if(elegirShiny == "Shiny"){
            Picasso.get().load(pokemonElegido?.sprites?.front_shiny).into(fotoPokemonTA)
        }
        else{
            Picasso.get().load(pokemonElegido?.sprites?.front_default).into(fotoPokemonTA)
        }

        tipoPokemonTA = findViewById(R.id.typenamePokemonAct)

        val typesText = "Tipo: " + pokemonElegido?.types?.joinToString(", ") { it.type.name }
        tipoPokemonTA.text = typesText

        //tipoPokemonTA.text = "Tipo" + pokemonElegido?.types?.type?.name.toString()
        val elegirGenero = when(pokemonElegido?.id?.toInt()?.rem(2)){
            0 -> "Female"
            else -> "Male"
        }
        generoPokemonTA = findViewById(R.id.genderPokemonAct)
        generoPokemonTA.text = "Género: " + elegirGenero

        numeroPokemonTA = findViewById(R.id.numberPokemonAct)
        numeroPokemonTA.text = "Número: " + pokemonElegido?.id.toString()

        recyclerViewFruit = findViewById(R.id.fruitRV)
        recyclerViewFruit.layoutManager = LinearLayoutManager(this)

        adapter3 = Adapter3(listadoDeFrutas)
        recyclerViewFruit.adapter = adapter3




        for(i in 1..5){
            getThePokemonFruit()
        }
    }

    private fun getThePokemonFruit(){
        CoroutineScope(Dispatchers.IO).launch {
            val listaFrutasExistentes = listOf("Strawberry","Banana","Tomato","Pineapple","Passionfruit","Orange","Raspberry","Papaya","Pitahaya","Dragonfruit","Avocado","Persimmon")
            val random = Random
            val randomNumber = random.nextInt(0, listaFrutasExistentes.size )
            val call = getRetrofit().create(ApiServiceFruit::class.java).getFruit(
                PokemonActivity.BASE_URL3 + listaFrutasExistentes[randomNumber].toString())
            val response = call.body()

            runOnUiThread{
                if (call.isSuccessful) {
                    val frutica: Fruit? = response

                    if (frutica != null) {
                        listadoDeFrutas.add(frutica)
                        adapter3.notifyDataSetChanged()
                    }

                } else {
                    Toast.makeText(this@PokemonActivity, randomNumber.toString(), Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL3)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val BASE_URL3 = "https://www.fruityvice.com/api/fruit/"
    }
}