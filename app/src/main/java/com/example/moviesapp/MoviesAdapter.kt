package com.example.moviesapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.moviesapp.databinding.SinglemovieBinding

class MoviesAdapter(): RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    lateinit var context: Context
    private  var moviesList = emptyList<Movie>()
    fun setMoviesList(moviesList: List<Movie>){
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(singleMovieBinding: SinglemovieBinding):RecyclerView.ViewHolder(singleMovieBinding.root) {
      val imageView = singleMovieBinding.movieImage
      val textView = singleMovieBinding.movieName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val singleMovieBinding = SinglemovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        this.context = parent.context
        return MovieViewHolder(singleMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var url = "https://media.istockphoto.com/vectors/movie-theater-with-row-of-red-seats-vector-id832125730?k=20&m=832125730&s=612x612&w=0&h=3ijKbVqGkQZeAFAu86nXkWOY6oaL16oVGEBaa6W7kms="
//        var url = "https://media.istockphoto.com/vectors/advertising-for-the-film-industry-film-popcorn-glasses-and-tickets-3d-vector-id1128891156?k=20&m=1128891156&s=612x612&w=0&h=7HjOLHkQioiRmPfPwcKAmkqTPnCk7DHP28I2FLDV99I="
        holder.textView.text=(moviesList[position].title)
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).transition(DrawableTransitionOptions.withCrossFade(2000)).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return this.moviesList.size
    }
}
