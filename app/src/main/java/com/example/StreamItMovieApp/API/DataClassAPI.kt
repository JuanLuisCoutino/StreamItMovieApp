package com.example.StreamItMovieApp.API

import com.example.StreamItMovieApp.ui.DataCall


data class Movie (val id: Int, val title: String, val image : String)

data class DataClassAPI (val PlayingNowList : List<Movie>)
