package com.example.StreamItMovieApp.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private const val BASE_URL = "https://api.themoviedb.org/3/movie/now_playing?"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val theMovieDbService : RequestAPI = retrofit.create(RequestAPI::class.java)

}