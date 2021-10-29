package com.example.moviesapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {
     var mutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
     var moviesRepository = MoviesRepository()

    fun loadMovies(){
       viewModelScope.launch {
           withContext(Dispatchers.IO){
               val response = moviesRepository.loadMovies()
               if(response.isSuccessful){
                   mutableLiveData.postValue(response.body()?.results)
               }
               else{
                   Log.e("Repository","Response is not successful")
               }
           }
       }
    }
}