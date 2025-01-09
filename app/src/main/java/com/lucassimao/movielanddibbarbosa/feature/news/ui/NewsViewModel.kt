package com.lucassimao.movielanddibbarbosa.feature.news.ui

import androidx.lifecycle.viewModelScope
import com.lucassimao.movielanddibbarbosa.core.ui.BaseViewModel
import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel
import com.lucassimao.movielanddibbarbosa.feature.news.domain.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : BaseViewModel<List<ArticleModel?>>() {

    fun getNews() {
        viewModelScope.launch {
            delay(3000)
            handleStateFlow(
                flow = repository.getData(),
                onError = { "Erro ao carregar notícias: ${it.message}" }
            )
        }
    }
}