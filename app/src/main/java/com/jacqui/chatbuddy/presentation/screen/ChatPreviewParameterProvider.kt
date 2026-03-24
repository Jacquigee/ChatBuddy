package com.jacqui.chatbuddy.presentation.screen

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.jacqui.chatbuddy.data.model.ChatModel
import com.jacqui.chatbuddy.data.model.Participant
import com.jacqui.chatbuddy.presentation.ChatUiState
import com.jacqui.chatbuddy.presentation.UiState

/**
 * Project Name: Chat Buddy
 * User        : jacqui
 * Email       : gitaujaquiline@gmail.com
 * Date        : Tue, 3/24/26
 * Time        : 9:23 AM
 */

class ChatPreviewParameterProvider : PreviewParameterProvider<ChatUiState> {
    override val values: Sequence<ChatUiState> = sequenceOf(
        ChatUiState(
            prompt = "Hello Gemini",
        ),
        ChatUiState(
            prompt = " Hello Gemini",
            messages = UiState.Loading,
            chats = emptyList()
        ),
        ChatUiState(
            prompt = " Hello Gemini",
            messages = UiState.Success(
                data = ChatModel(
                    prompt = "Hello Gemini",
                    participant = Participant.USER
                )
            ),
            chats = listOf(
                ChatModel(
                    prompt = "Hello Gemini",
                    participant = Participant.USER
                ),
                ChatModel(
                    prompt = "Hello Jacqui, how may I help you today",
                    participant = Participant.MODEL
                ),
            )
        )
    )

}