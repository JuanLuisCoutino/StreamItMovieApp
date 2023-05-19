package com.example.StreamItMovieApp.API

import android.app.DownloadManager
import android.view.textclassifier.ConversationActions.Request
import org.intellij.lang.annotations.Language
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestAPI {

    @GET("movie/now_playing")
    suspend fun getPlayingNowList(@Query("language") language: String, @Query("page") page : Int) : DataClassAPI
}


