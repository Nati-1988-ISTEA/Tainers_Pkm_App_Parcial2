package com.example.tainers_pkm_app_parcial2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiServiceTrainer {

    @GET
    suspend fun getTrainer(@Url url: String): Response<Trainer>

}