package com.example.moviesapp

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://api.themoviedb.org")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    fun getApi(): MoviesApi{
        return retrofit.create(MoviesApi::class.java)
    }
}
