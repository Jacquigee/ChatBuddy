package com.jacqui.chatbuddy.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jacqui.chatbuddy.data.GeminiApiImplementation
import com.jacqui.chatbuddy.data.model.ChatModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * PROJECT NAME: Chat Buddy
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Mar, 3/2/24
 * TIME        : 9:04 PM
 */

data class ChatUiState(
    val prompt: String = "",
    val messages: UiState<ChatModel> = UiState.Idle,
    val chats: List<ChatModel> = emptyList()
) {
    val isActionEnabled: Boolean
        get() = prompt.isNotBlank() and (messages !is UiState.Loading)

    val isPromptEnabled: Boolean
        get() = messages !is UiState.Loading
}

class ChatViewModel : ViewModel() {
    private val _chatUiState = MutableStateFlow(ChatUiState())
    val chatUiState = _chatUiState.asStateFlow()


    fun onValueChangePrompt(value: String) {
        _chatUiState.update { it.copy(prompt = value) }
    }

    fun onClickSubmit() {
        sendPrompt()

    }

    private fun sendPrompt() {
        val prompt = _chatUiState.value.prompt
        addChat(ChatModel(prompt = prompt))

        viewModelScope.launch {
            val result = GeminiApiImplementation.getPrompt(prompt = _chatUiState.value.prompt)
            _chatUiState.update { it.copy(messages = UiState.Success(data = result)) }
            addChat(result)
        }
    }

    private fun addChat(model: ChatModel) {
        val chats = _chatUiState.value.chats.toMutableList()
        chats.add(model)
        _chatUiState.update { it.copy(chats = chats) }
    }

}
