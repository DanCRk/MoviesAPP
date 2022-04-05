package com.dann.moviesapp.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dann.moviesapp.data.adapter.AdapterRV
import com.dann.moviesapp.data.model.MovieModel
import com.dann.moviesapp.databinding.FragmentPlayingNowBinding
import com.dann.moviesapp.domain.model.Movie
import com.dann.moviesapp.ui.viewmodel.PlayingNowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayingNowFragment : Fragment() {

    private var _binding: FragmentPlayingNowBinding? = null
    private val binding get() = _binding!!

    private val vm: PlayingNowViewModel by viewModels()

    private lateinit var adapter:AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPlayingNowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.onCreate()

        vm.movies.observe(viewLifecycleOwner){ movies ->
            setReciclerView(movies)
        }

        vm.isLoading.observe(viewLifecycleOwner){ isloading ->
            binding.progressBar.isVisible = isloading
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setReciclerView(list:List<Movie>){
        adapter = AdapterRV(list) {movies -> onItemSelected(movies) }
        binding.rv.layoutManager = GridLayoutManager(context,3)
        binding.rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun onItemSelected(movie: Movie){
        val intent = Intent(activity, MovieDetailsActivity::class.java)
        intent.putExtra("movie", movie)
        activity?.startActivity(intent)
    }

}