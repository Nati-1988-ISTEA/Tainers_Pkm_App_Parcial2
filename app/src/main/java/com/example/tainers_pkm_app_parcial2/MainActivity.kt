package com.example.tainers_pkm_app_parcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewTrainer: RecyclerView
    private lateinit var adapter: Adapter
    private var listadoDeEntrenadores = mutableListOf<Result>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewTrainer = findViewById(R.id.trainerRV)
        recyclerViewTrainer.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(listadoDeEntrenadores)
        recyclerViewTrainer.adapter = adapter

        getListOftrainers()




    }


    private fun getListOftrainers(){

            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(ApiServiceTrainer::class.java).getTrainer(END_POINT)
                val response = call.body()

                runOnUiThread{
                    if (call.isSuccessful) {

                        val entrenadores = response?.results ?: listOf()

                        listadoDeEntrenadores.clear()
                        listadoDeEntrenadores.addAll(entrenadores)

                        adapter.notifyDataSetChanged()
                        Toast.makeText(this@MainActivity, "Llamada exitosa", Toast.LENGTH_SHORT).show()




                    }




            }
        }


    }




    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    companion object {
        const val BASE_URL = "https://randomuser.me/"
        const val END_POINT = "api/?results=9"
    }


}