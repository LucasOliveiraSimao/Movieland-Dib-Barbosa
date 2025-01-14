package com.lucassimao.movielanddibbarbosa.feature.movie_play_now.ui

import androidx.lifecycle.viewModelScope
import com.lucassimao.movielanddibbarbosa.core.ui.BaseViewModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.data.model.PlayNowMovieModel
import com.lucassimao.movielanddibbarbosa.feature.movie_play_now.domain.PlayNowMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayNowMoviesViewModel @Inject constructor(
    private val repository: PlayNowMoviesRepository
) : BaseViewModel<List<PlayNowMovieModel>>() {

    fun getPlayNowMovies() {
        viewModelScope.launch {
            handleStateFlow(
                flow = repository.getData(),
                onError = { "Erro ao carregar filmes: ${it.message}" }
            )
        }
    }
}