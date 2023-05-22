package com.example.StreamItMovieApp.API

import androidx.constraintlayout.solver.state.State.Chain
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val httpClient = OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BODY
        })
        addInterceptor{ chain ->
            val original = chain.request()
            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", "a18af9730f4b36fd3032baedeeb0de39")
                .build()

            val requestBuilder = original.newBuilder().url(url)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }.build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val theMovieDbService : RequestAPI = retrofit.create(RequestAPI::class.java)

}