package com.jacqui.chatbuddy.model

import java.util.UUID

/**
 * PROJECT NAME: Chat Buddy
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Mar, 3/2/24
 * TIME        : 8:57 PM
 */

enum class Participant {
    USER, MODEL, ERROR
}

data class ChatModel(
    val id: String = UUID.randomUUID().toString(),
    val text: String = "",
    val participant: Participant = Participant.USER,
    var isPending: Boolean = true
)
