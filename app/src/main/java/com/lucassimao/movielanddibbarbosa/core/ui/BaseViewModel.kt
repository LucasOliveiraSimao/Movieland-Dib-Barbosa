package com.lucassimao.movielanddibbarbosa.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

open class BaseViewModel<T> : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<T>>(UiState.Loading)
    val uiState: StateFlow<UiState<T>> get() = _uiState

    protected fun handleStateFlow(
        flow: Flow<T>,
        onError: (Throwable) -> String = { "Error: ${it.message}" }
    ) {
        viewModelScope.launch {
            flow.map { result ->
                UiState.Success(result)
            }
                .catch { exception ->
                    _uiState.value = UiState.Error(onError(exception))
                }
                .stateIn(
                    viewModelScope,
                    started = SharingStarted.Lazily,
                    initialValue = UiState.Loading
                )
                .collect { data ->
                    _uiState.value = data
                }
        }
    }
}