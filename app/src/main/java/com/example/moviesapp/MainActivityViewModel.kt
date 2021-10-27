package com.example.moviesapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
     var mutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
     var moviesRepository = MoviesRepository()

    init{
        moviesRepository.loadMovies()
        mutableLiveData = moviesRepository.getMoviesLiveData()
    }
}