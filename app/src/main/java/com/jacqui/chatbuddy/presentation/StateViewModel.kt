package com.jacqui.chatbuddy.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


sealed interface UiState<out T> {

    data class Error(val message: String) : UiState<Nothing>

    data class Success<T>(val data: T) : UiState<T>

    data object Loading : UiState<Nothing>

    data object Idle : UiState<Nothing>

}
