package com.dann.moviesapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dann.moviesapp.R
import com.dann.moviesapp.data.model.Movie
import com.dann.moviesapp.databinding.MovieItemBinding

class AdapterRV(
    private val movies:List<Movie>,
    private val onClickListener:(Movie) -> Unit
): RecyclerView.Adapter<AdapterRV.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], onClickListener)
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view) {

        private val binding = MovieItemBinding.bind(view)

        fun bind(movie: Movie, onClickListener: (Movie) -> Unit) {
            val url = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
            Glide.with(view.context)
                .load(url)
                .into(binding.posterImage)

            binding.titleMovie.text = movie.original_title

            binding.popularity.text = movie.popularity.toString()

            itemView.setOnClickListener {
                onClickListener(movie)
            }
        }


    }
}


