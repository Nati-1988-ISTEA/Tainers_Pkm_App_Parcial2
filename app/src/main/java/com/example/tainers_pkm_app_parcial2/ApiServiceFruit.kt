package com.example.tainers_pkm_app_parcial2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiServiceFruit {

    @GET
    suspend fun getFruit(@Url url: String): Response<Fruit>

}