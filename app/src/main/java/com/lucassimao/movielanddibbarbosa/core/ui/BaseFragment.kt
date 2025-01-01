package com.lucassimao.movielanddibbarbosa.core.ui

import androidx.fragment.app.Fragment

abstract class BaseFragment<T> : Fragment() {

    protected open fun collectUiState() {}

    protected open fun handleLoadingState() {}

    protected open fun handleSuccessState(state: UiState.Success<T>) {}

    protected open fun handleErrorState(state: UiState.Error) {}
}
