package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.ui

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
import com.lucassimao.movielanddibbarbosa.databinding.FragmentComingSoonMoviesBinding
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComingSoonMoviesFragment : BaseFragment<List<ComingSoonMovieModel>>() {
    private lateinit var binding: FragmentComingSoonMoviesBinding
    private val viewModel by viewModels<ComingSoonMoviesViewModel>()
    private val comingSoonAdapter = ComingSoonMoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComingSoonMoviesBinding.inflate(inflater, container, false)
        viewModel.getComingSoonMovies()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shimmerAdapter: ShimmerAdapter by lazy {
            ShimmerAdapter(layoutShimmer = R.layout.item_shimmer)
        }

        setupRecyclerViews(shimmerAdapter)

        collectUiState()

    }

    private fun setupRecyclerViews(shimmerAdapter: ShimmerAdapter) {
        val gridLayoutManagerShimmer = GridLayoutManager(requireContext(), 2)
        val gridLayoutManagerComingSoon = GridLayoutManager(requireContext(), 2)

        binding.shimmerRecyclerView.apply {
            layoutManager = gridLayoutManagerShimmer
            adapter = shimmerAdapter
        }
        binding.rvComingSoonMovies.apply {
            layoutManager = gridLayoutManagerComingSoon
            adapter = comingSoonAdapter
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
        binding.rvComingSoonMovies.visibility = View.GONE
    }

    override fun handleSuccessState(state: UiState.Success<List<ComingSoonMovieModel>>) {
        binding.shimmerFrameLayout.apply {
            visibility = View.GONE
            stopShimmer()
        }
        binding.rvComingSoonMovies.visibility = View.VISIBLE
        comingSoonAdapter.submitList(state.data)

    }

    override fun handleErrorState(state: UiState.Error) {
        Toast.makeText(requireContext(), "Erro: ${state.message}", Toast.LENGTH_SHORT).show()
    }
}