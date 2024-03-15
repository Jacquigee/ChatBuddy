package com.jacqui.chatbuddy.presentation

import androidx.lifecycle.viewModelScope
import com.jacqui.chatbuddy.data.GeminiApiImplementation
import com.jacqui.chatbuddy.data.model.ChatModel
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
    val messages: UiListState<ChatModel> = UiListState.Idle,
    val chats: List<ChatModel> = emptyList()
) {
    val isActionEnabled: Boolean
        get() = prompt.isNotBlank() and (messages !is UiListState.Loading)

    val isPromptEnabled: Boolean
        get() = messages !is UiListState.Loading
}

class ChatViewModel : StateViewModel<ChatUiState>(ChatUiState()) {
    fun onValueChangePrompt(value: String) {
        update { copy(prompt = value)}
    }

    fun onClickSubmit() {
        sendPrompt()

    }

    private fun sendPrompt() {
        val prompt = state.value.prompt
        addChat(ChatModel(prompt = prompt))

        viewModelScope.launch {
            val result = GeminiApiImplementation.getPrompt(prompt = state.value.prompt)
            update { copy(messages = UiListState.Success(data = result)) }
            addChat(result)
        }
    }

    private fun addChat(model: ChatModel) {
        val chats = state.value.chats.toMutableList()
        chats.add(model)
        update { copy(chats = chats) }
    }

}
