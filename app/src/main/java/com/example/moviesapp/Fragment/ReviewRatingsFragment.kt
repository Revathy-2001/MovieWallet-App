package com.example.moviesapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragementReviewsRatingsBinding
import com.example.moviesapp.databinding.FragmentOverViewBinding

class ReviewRatingsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragementReviewsRatingsBinding = FragementReviewsRatingsBinding.inflate(inflater)

        var ratingBar = fragementReviewsRatingsBinding.ratingBar
        var ratingScale = fragementReviewsRatingsBinding.RatingScale
        var reviewInput = fragementReviewsRatingsBinding.Review
        var reviewSubmit = fragementReviewsRatingsBinding.ReviewSubmit

        ratingBar.onRatingBarChangeListener = OnRatingBarChangeListener { ratingBar:RatingBar, v:Float, b:Boolean ->
            ratingScale.text = v.toString()
            when((ratingBar.rating).toInt()){
                1 -> ratingScale.text = "Very bad"
                2 -> ratingScale.text = "Bad"
                3 -> ratingScale.text = "Better"
                4 -> ratingScale.text = "Good"
                5 -> ratingScale.text = "Very Good"
            }
        }
        return fragementReviewsRatingsBinding.root
    }
}