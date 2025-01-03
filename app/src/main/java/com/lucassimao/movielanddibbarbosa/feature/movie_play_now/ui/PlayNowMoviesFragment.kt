package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.lucassimao.movielanddibbarbosa.R
import com.lucassimao.movielanddibbarbosa.core.ui.BaseFragment
import com.lucassimao.movielanddibbarbosa.core.ui.ShimmerAdapter
import com.lucassimao.movielanddibbarbosa.core.ui.UiState
import com.lucassimao.movielanddibbarbosa.databinding.FragmentPlayNowMoviesBinding
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.MovieModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayNowMoviesFragment : BaseFragment<List<MovieModel>>() {
    private lateinit var binding: FragmentPlayNowMoviesBinding
    private val viewModel by viewModels<PlayNowMoviesViewModel>()
    private val playNowAdapter = PlayNowMoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayNowMoviesBinding.inflate(inflater, container, false)
        viewModel.getPlayNowMovies()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shimmerAdapter: ShimmerAdapter by lazy {
            ShimmerAdapter(layoutShimmer = R.layout.item_shimmer_play_now_movie)
        }

        setupRecyclerViews(shimmerAdapter)

        collectUiState()

    }

    private fun setupRecyclerViews(shimmerAdapter: ShimmerAdapter) {
        val gridLayoutManagerShimmer = GridLayoutManager(requireContext(), 2)
        val gridLayoutManagerPlayNow = GridLayoutManager(requireContext(), 2)

        binding.shimmerRecyclerView.apply {
            layoutManager = gridLayoutManagerShimmer
            adapter = shimmerAdapter
        }
        binding.rvPlayNowMovies.apply {
            layoutManager = gridLayoutManagerPlayNow
            adapter = playNowAdapter
        }
    }

    override fun collectUiState() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is UiState.Loading -> handleLoadingState()
                    is UiState.Success -> handleSuccessState(state)
                    is UiState.Error -> handleErrorState(state)
                }
            }
        }
    }

    override fun handleLoadingState() {
        binding.shimmerFrameLayout.apply {
            visibility = View.VISIBLE
            startShimmer()
        }
        binding.rvPlayNowMovies.visibility = View.GONE
    }

    override fun handleSuccessState(state: UiState.Success<List<MovieModel>>) {
        binding.shimmerFrameLayout.apply {
            visibility = View.GONE
            stopShimmer()
        }
        binding.rvPlayNowMovies.visibility = View.VISIBLE
        playNowAdapter.submitList(state.data)

    }

    override fun handleErrorState(state: UiState.Error) {
        Toast.makeText(requireContext(), "Erro: ${state.message}", Toast.LENGTH_SHORT).show()
    }
}