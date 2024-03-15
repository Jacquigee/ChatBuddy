package com.jacqui.chatbuddy.data.model

/**
 * PROJECT NAME: Chat Buddy
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Mar, 3/2/24
 * TIME        : 8:57 PM
 */

enum class Participant {
    USER, MODEL
}

data class ChatModel(
    val prompt: String = "",
    val participant: Participant = Participant.USER,
)
