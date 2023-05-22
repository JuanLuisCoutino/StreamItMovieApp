package com.example.StreamItMovieApp.API

import com.example.StreamItMovieApp.ui.PlayingNowList
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestAPI {

    @GET("movie/now_playing")
    suspend fun getPlayingNowList(@Query("api_key") apikey : String,
                                  @Query("language") language: String,
                                  @Query("page") page : Int) : PlayingNowList
}


