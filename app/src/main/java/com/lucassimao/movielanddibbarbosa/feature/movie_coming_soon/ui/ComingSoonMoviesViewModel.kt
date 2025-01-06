package com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.ui

import androidx.lifecycle.viewModelScope
import com.lucassimao.movielanddibbarbosa.core.ui.BaseViewModel
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.data.model.ComingSoonMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_coming_soon.domain.ComingSoonMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComingSoonMoviesViewModel @Inject constructor(
    private val repository: ComingSoonMoviesRepository
) : BaseViewModel<List<ComingSoonMovieModel>>() {

    fun getComingSoonMovies() {
        viewModelScope.launch {
            delay(3000)
            handleStateFlow(
                flow = repository.getData(),
                onError = { "Erro ao carregar filmes: ${it.message}" }
            )
        }
    }
}