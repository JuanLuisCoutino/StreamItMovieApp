package com.example.StreamItMovieApp.API

import com.example.StreamItMovieApp.ui.PlayingNowList
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestAPI {

    @GET("movie/550?")
    suspend fun getPlayingNowList(
                                  @Query("api_key") api_key : String): PlayingNowList
}


