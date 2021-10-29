package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.ActivityMainBinding
import android.R
import android.view.View
import android.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var activityMainBinding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        var recyclerView:RecyclerView = activityMainBinding.recyclerViewMovies
        var moviesAdapter = MoviesAdapter()

        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        recyclerView.adapter = moviesAdapter
        var mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.loadMovies()
        mainActivityViewModel.mutableLiveData.observe(this, Observer {
            moviesAdapter.setMoviesList(it)
        })
    }
}
