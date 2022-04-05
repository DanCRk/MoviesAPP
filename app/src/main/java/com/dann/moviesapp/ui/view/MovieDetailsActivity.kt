package com.dann.moviesapp.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dann.moviesapp.data.model.MovieModel
import com.dann.moviesapp.databinding.ActivityMoiveDetailsBinding
import com.dann.moviesapp.domain.model.Movie

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoiveDetailsBinding
    private var movie = Movie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoiveDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMovie()

        setInformationInViews()
    }

    private fun getMovie(){
        movie = intent.getSerializableExtra("movie") as Movie
    }

    @SuppressLint("SetTextI18n")
    private fun setInformationInViews() {
        val avg = (movie.vote_average*10).toInt()
        binding.collpTb.title = movie.original_title
        binding.average.progress = avg
        binding.averagePercentage.text = "$avg%"
        if(!movie.backdrop_path.equals("_")){
            val url = "https://image.tmdb.org/t/p/w500${movie.backdrop_path}"
            Glide.with(this)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.imgMovieDetail)
        }else{
            val url = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
            Glide.with(this)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.imgMovieDetail)
        }
        binding.description.text = movie.overview

        if (movie.adult){
            binding.categotyTrue.text = "Yes"
        }else{
            binding.categotyTrue.text = "No"
        }

        binding.language.text = "${movie.original_language}"

        binding.popularityNumber.text = "${movie.popularity}".replace(".",",")

        binding.releaseDateDate.text = "${movie.release_date}"
    }
}