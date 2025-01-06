package com.lucassimao.movielanddibbarbosa.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.lucassimao.movielanddibbarbosa.R
import com.lucassimao.movielanddibbarbosa.databinding.FragmentMoviesBinding
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.ui.ComingSoonMoviesFragment
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.ui.PlayNowMoviesFragment

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViewPager(binding.vpMovies)
        binding.tlMovies.setupWithViewPager(binding.vpMovies)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(PlayNowMoviesFragment(), getString(R.string.movies_play_now))
        adapter.addFragment(ComingSoonMoviesFragment(), getString(R.string.movies_coming_soon))
        viewPager.adapter = adapter
        binding.tlMovies.setupWithViewPager(viewPager)
    }

}