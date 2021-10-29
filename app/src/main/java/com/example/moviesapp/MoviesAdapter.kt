package com.example.moviesapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.moviesapp.databinding.SinglemovieBinding
import kotlinx.parcelize.Parcelize

class MoviesAdapter(): RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    lateinit var context: Context
    private  var moviesList = emptyList<Movie>()
    fun setMoviesList(moviesList: List<Movie>){
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(singleMovieBinding: SinglemovieBinding):RecyclerView.ViewHolder(singleMovieBinding.root) {
      val Intent:Intent? = null
      val imageView = singleMovieBinding.movieImage
      val textView = singleMovieBinding.movieName
       init {
           singleMovieBinding.root.setOnClickListener{
               val movie = moviesList[adapterPosition]
               val intent = Intent(context, SingleMovieActivity::class.java)
               intent.putExtra("MovieObject",movie)
               context.startActivity(intent)
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val singleMovieBinding = SinglemovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        this.context = parent.context
        return MovieViewHolder(singleMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var url = "https://media.istockphoto.com/vectors/movie-theater-with-row-of-red-seats-vector-id832125730?k=20&m=832125730&s=612x612&w=0&h=3ijKbVqGkQZeAFAu86nXkWOY6oaL16oVGEBaa6W7kms="
        holder.textView.text=(moviesList[position].title)
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).transition(DrawableTransitionOptions.withCrossFade(2000)).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return this.moviesList.size
    }
}
