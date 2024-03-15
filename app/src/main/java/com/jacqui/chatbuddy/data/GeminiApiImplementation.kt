package com.jacqui.chatbuddy.data

import com.google.ai.client.generativeai.GenerativeModel
import com.jacqui.chatbuddy.data.model.ChatModel
import com.jacqui.chatbuddy.data.model.Participant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object GeminiApiImplementation {

    val apiKey = "AIzaSyDiKwQaklQ_tmfrArJ65JACnbcDW6OIFXk"

    suspend fun getPrompt(prompt: String): ChatModel {
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro", apiKey = apiKey
        )
        try {
            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(prompt)
            }
            return ChatModel(
                prompt = response.text ?: "Error",
                participant = Participant.MODEL
            )
        } catch (e: Exception){
            return ChatModel(
                prompt = e.message ?: "Error",
                participant = Participant.MODEL

            )
        }

    }
}