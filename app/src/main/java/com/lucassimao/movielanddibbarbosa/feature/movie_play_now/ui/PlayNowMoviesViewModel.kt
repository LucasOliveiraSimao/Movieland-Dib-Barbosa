package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.ui

import androidx.lifecycle.viewModelScope
import com.lucassimao.movielanddibbarbosa.core.ui.BaseViewModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.MovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayNowMoviesViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel<List<MovieModel>>() {

    fun getPlayNowMovies() {
        viewModelScope.launch {
            delay(3000)
            handleStateFlow(
                flow = repository.getData().map { result ->
                    result.movies ?: emptyList()
                },
                onError = { "Erro ao carregar filmes: ${it.message}" }
            )
        }
    }
}