package com.example.moviesapp.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviesapp.Movie
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentOverViewBinding

class OverViewFragment : Fragment() {
    var movie:Movie? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle= this.arguments
        if(bundle != null) {
             movie = bundle.getParcelable("movieObj")
        }
        else{
            Log.e("Bundle","Bundle is Null")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragmentOverViewBinding = FragmentOverViewBinding.inflate(inflater)



        fragmentOverViewBinding.movieNameText.text = movie?.title
        fragmentOverViewBinding.language.text = "Drama"
        fragmentOverViewBinding.description.text = movie?.overview
        fragmentOverViewBinding.likesTxt.text = (movie?.vote_count).toString()

        // Inflate the layout for this fragment
        return fragmentOverViewBinding.root
    }
}