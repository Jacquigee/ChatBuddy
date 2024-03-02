package com.jacqui.chatbuddy.presentation

import com.jacqui.chatbuddy.model.ChatModel

/**
 * PROJECT NAME: Chat Buddy
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Mar, 3/2/24
 * TIME        : 9:04 PM
 */

class ChatUiState (
    messages: List<ChatModel> = emptyList()
){
    /**
     * _message is a mutable list[MutableList] of [ChatModel] objects.
     * It is initialized with the provided list of messages or an emptyLit if there are no messages found.
     *
     */
    private val _messages: MutableList<ChatModel> = messages.toMutableList()
    val messages: List<ChatModel> = _messages

    fun addMessage(msg: ChatModel){
        _messages.add(msg)
    }

    fun replaceLastPendingMessage(){
        val lastMessage = _messages.lastOrNull()
        lastMessage?.let {
            val newMessage = lastMessage.apply { isPending = false }
            _messages.removeLast()
            _messages.add(newMessage)
        }
    }
}
