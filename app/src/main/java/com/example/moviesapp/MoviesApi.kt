package com.example.moviesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/3/movie/popular")
    fun getMovies(
    @Query("api_key") apiKey: String = "70f1af0414884e2a8c51ac9875b2e4cf",
    ): Call<MoviesInTotal>
}