package com.example.moviesapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository {

// private val mutableLiveData = MutableLiveData<List<Movie>>()

   private var call = RetrofitClient.getApi().getMovies()
   fun loadMovies() :Response<MoviesInTotal> {
       return call.execute()
//       call.enqueue(object : Callback<MoviesInTotal> {
//           override fun onResponse(call: Call<MoviesInTotal>, response: Response<MoviesInTotal>) {
//               Log.e("RetrofitClient:", "${Thread.currentThread().name}")
//
//               if (response.isSuccessful) {
//                   mutableLiveData.postValue(response.body()?.results);
//                   Log.e("Repository", "Movies: ${response.body()?.results}")
//               }
//               else{
//                   Log.e("Repository","Response is not successful")
//               }
//           }
//
//           override fun onFailure(call: Call<MoviesInTotal>, t: Throwable) {
//               Log.e("Repository", "onFailure",t)
//           }
//       })
   }
//
//    fun getMoviesLiveData(): MutableLiveData<List<Movie>>{
//        return mutableLiveData
//    }
}
