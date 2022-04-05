package com.dann.moviesapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dann.moviesapp.R
import com.dann.moviesapp.data.model.MovieModel
import com.dann.moviesapp.databinding.MovieItemBinding
import com.dann.moviesapp.domain.model.Movie

class AdapterRV(
    private val movieModels:List<Movie>,
    private val onClickListener:(Movie) -> Unit
): RecyclerView.Adapter<AdapterRV.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieModels[position], onClickListener)
    }

    override fun getItemCount(): Int = movieModels.size

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view) {

        private val binding = MovieItemBinding.bind(view)

        fun bind(movieModel: Movie, onClickListener: (Movie) -> Unit) {
            val url = "https://image.tmdb.org/t/p/w500${movieModel.poster_path}"
            Glide.with(view.context)
                .load(url)
                .into(binding.posterImage)

            binding.titleMovie.text = movieModel.original_title

            binding.popularity.text = movieModel.popularity.toString()

            itemView.setOnClickListener {
                onClickListener(movieModel)
            }
        }


    }
}


