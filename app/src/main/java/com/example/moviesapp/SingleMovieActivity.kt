package com.example.moviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.moviesapp.Fragment.OverViewFragment
import com.example.moviesapp.Fragment.ReviewRatingsFragment
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.databinding.ActivityMainBinding.inflate
import com.example.moviesapp.databinding.ActivitySingleMovieBinding

class SingleMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activitySingleMovieBinding = ActivitySingleMovieBinding.inflate(layoutInflater)
        setContentView(activitySingleMovieBinding.root)

        Log.e("SingleMovieActivity:", "${Thread.currentThread().name}")
        var intent = intent
        var movie: Movie? = intent.getParcelableExtra("MovieObject")

        var url = "https://cdn.wallpapersafari.com/63/91/EGjUcK.jpg"
        Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).into(activitySingleMovieBinding.imageView)

        val data = Bundle()
        data.putParcelable("movieObj", movie)
        //setting up tabs
        var adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OverViewFragment().apply { arguments = data }, "Overview")
        adapter.addFragment(ReviewRatingsFragment().apply { arguments = data }, "Reviews & Ratings")

        val viewPager = activitySingleMovieBinding.ViewPager
        viewPager.adapter = adapter
        activitySingleMovieBinding.tabs.setupWithViewPager(viewPager)

        Log.e("Arguments", data.toString())
    }

}