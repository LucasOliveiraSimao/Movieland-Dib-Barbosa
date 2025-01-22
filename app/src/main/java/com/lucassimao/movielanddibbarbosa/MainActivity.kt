package com.lucassimao.movielanddibbarbosa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.nav_host_fragment)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.movies -> {
                    navController.navigate(R.id.moviesFragment)
                    true
                }

                R.id.news -> {
                    navController.navigate(R.id.newsFragment)
                    true
                }

                R.id.info -> {
                    navController.navigate(R.id.infoFragment)
                    true
                }

                else -> false
            }
        }
    }
}