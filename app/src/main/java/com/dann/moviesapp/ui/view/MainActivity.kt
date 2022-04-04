package com.dann.moviesapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.dann.moviesapp.R
import com.dann.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setNavController()
    }

    fun setNavController() {
        // Asignar el bottom nav
        val btmNav = binding.bottomNav
        // Instanciar un controllador
        val navControler = Navigation.findNavController(this, R.id.frag_host)
        // Settear el controlador a nuestro nav
        NavigationUI.setupWithNavController(btmNav, navControler)
    }
}