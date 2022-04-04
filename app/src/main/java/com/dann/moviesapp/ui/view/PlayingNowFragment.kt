package com.dann.moviesapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dann.moviesapp.databinding.FragmentPlayingNowBinding

class PlayingNowFragment : Fragment() {

    private var _binding: FragmentPlayingNowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPlayingNowBinding.inflate(inflater, container, false)
        return binding.root
    }

}