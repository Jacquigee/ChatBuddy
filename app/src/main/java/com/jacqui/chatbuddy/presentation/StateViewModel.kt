package com.jacqui.chatbuddy.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


sealed interface UiListState<out T> {

    data class Error(val message: String) : UiListState<Nothing>

    data class Success<T>(val data: T) : UiListState<T>

    data object Loading : UiListState<Nothing>

    data object Idle : UiListState<Nothing>

}
open class StateViewModel<T>(initial: T) : ViewModel() {

    private val _state = MutableStateFlow(initial)
    val state get() = _state.asStateFlow()

    fun update(value: T) {
        _state.update {
            value
        }
    }

    fun update(block: T.() -> T) {
        update(state.value.block())
    }


}