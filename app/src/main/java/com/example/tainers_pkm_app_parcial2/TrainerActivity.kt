package com.example.tainers_pkm_app_parcial2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class TrainerActivity : AppCompatActivity() {

    private lateinit var recyclerViewPokemon: RecyclerView
    private lateinit var nombreTrainerTA: TextView
    private lateinit var fotoTrainerTA: ImageView
    private lateinit var paisTrainerTA: TextView
    private lateinit var generoTrainerTA: TextView
    private lateinit var edadTrainerTA: TextView
    private lateinit var adapter2: Adapter2
    private var listadoDePokemones = mutableListOf<Pokemon>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer)

        val entrenador = intent.getParcelableExtra<Result>("results")

        nombreTrainerTA = findViewById(R.id.nameTrainerAct)
        nombreTrainerTA.text = entrenador?.name?.title.toString() + ". "+ entrenador?.name?.first.toString()+ " " + entrenador?.name?.last.toString()

        fotoTrainerTA = findViewById(R.id.photoTrainerAct)
        Picasso.get().load(entrenador?.picture?.large).into(fotoTrainerTA)

        paisTrainerTA = findViewById(R.id.nationTrainerAct)
        paisTrainerTA.text = "Country: " + entrenador?.location?.country.toString()

        generoTrainerTA = findViewById(R.id.genderTrainerAct)
        generoTrainerTA.text = "Gender: " + entrenador?.gender.toString()

        edadTrainerTA = findViewById(R.id.ageTrainer)
        edadTrainerTA.text ="Age: " + entrenador?.dob?.age.toString()


        recyclerViewPokemon = findViewById(R.id.pokemonRV)
        recyclerViewPokemon.layoutManager = LinearLayoutManager(this)

        adapter2 = Adapter2(listadoDePokemones)
        recyclerViewPokemon.adapter = adapter2

        for(i in 1..6){
            getListOfPokemons()
        }


        adapter2.onItemClickListener = {resultadoPkm ->
            navegarDetalle(resultadoPkm)
        }
    }

    private fun navegarDetalle(resultadoPkm: Pokemon) {
        val intent = Intent(this, PokemonActivity:: class.java)
        intent.putExtra("pokemon", resultadoPkm)
        startActivity(intent)
    }

    private fun getListOfPokemons(){
        CoroutineScope(Dispatchers.IO).launch {
            val random = Random
            val randomNumber = random.nextInt(1, 152)
            val call = getRetrofit().create(ApiServicePokemon::class.java).getPokemon(BASE_URL2 + randomNumber)
            val response = call.body()

            runOnUiThread{
                if (call.isSuccessful) {
                    val pokemonez:Pokemon? = response
                    //listadoDePokemones.clear()
                    if (pokemonez != null) {
                        listadoDePokemones.add(pokemonez)
                        adapter2.notifyDataSetChanged()
                    }

                } else {
                    Toast.makeText(this@TrainerActivity, response.toString(), Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val BASE_URL2 = "https://pokeapi.co/api/v2/pokemon-form/"
    }

}
