package com.lucassimao.movielanddibbarbosa.feature.news.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucassimao.movielanddibbarbosa.R
import com.lucassimao.movielanddibbarbosa.core.ui.BaseFragment
import com.lucassimao.movielanddibbarbosa.core.ui.ShimmerAdapter
import com.lucassimao.movielanddibbarbosa.core.ui.UiState
import com.lucassimao.movielanddibbarbosa.databinding.FragmentNewsBinding
import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsFragment : BaseFragment<List<ArticleModel?>>() {
    private lateinit var binding: FragmentNewsBinding
    private val viewModel by viewModels<NewsViewModel>()
    private val newsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        viewModel.getNews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shimmerAdapter: ShimmerAdapter by lazy {
            ShimmerAdapter(layoutShimmer = R.layout.item_shimmer_news)
        }

        setupRecyclerViews(shimmerAdapter)
        collectUiState()
    }

    private fun setupRecyclerViews(shimmerAdapter: ShimmerAdapter) {
        val gridLayoutManagerShimmer = LinearLayoutManager(requireContext())
        val linearLayoutManagerNews = LinearLayoutManager(requireContext())

        binding.shimmerRecyclerView.apply {
            layoutManager = gridLayoutManagerShimmer
            adapter = shimmerAdapter
        }
        binding.rvNews.apply {
            layoutManager = linearLayoutManagerNews
            adapter = newsAdapter
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
        binding.rvNews.visibility = View.GONE
    }

    override fun handleSuccessState(state: UiState.Success<List<ArticleModel?>>) {
        binding.shimmerFrameLayout.apply {
            visibility = View.GONE
            stopShimmer()
        }
        binding.rvNews.visibility = View.VISIBLE
        newsAdapter.submitList(state.data)

    }

    override fun handleErrorState(state: UiState.Error) {
        Toast.makeText(requireContext(), "Erro: ${state.message}", Toast.LENGTH_SHORT).show()
    }

}