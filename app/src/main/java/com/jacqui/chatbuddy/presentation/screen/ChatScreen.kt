package com.jacqui.chatbuddy.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.jacqui.chatbuddy.R
import com.jacqui.chatbuddy.data.model.Participant
import com.jacqui.chatbuddy.presentation.ChatUiState
import com.jacqui.chatbuddy.presentation.ChatViewModel
import com.jacqui.chatbuddy.presentation.UiListState
import com.jacqui.chatbuddy.presentation.components.ModelChatItem
import com.jacqui.chatbuddy.presentation.components.UserChatItem

@Composable
fun ChatScreen(viewModel: ChatViewModel) {
    val state by viewModel.state.collectAsState()

    ChatScreenContent(
        state = state,
        onValueChangePrompt = viewModel::onValueChangePrompt,
        onClickSubmit = viewModel::onClickSubmit
    )
}

@Composable
fun ChatScreenContent(
    state: ChatUiState,
    onValueChangePrompt: (String) -> Unit,
    onClickSubmit: () -> Unit
) {

    Scaffold() {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AnimatedContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                targetState = state.messages
            ) { messages ->
                when (messages) {
                    is UiListState.Error -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = messages.message)
                        }
                    }

                    UiListState.Idle -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Idle")
                        }
                    }

                    UiListState.Loading -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is UiListState.Success -> {
                        val chat = state.chats
                        if (chat.isEmpty()) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "Empty")
                            }
                        } else {
                            LazyColumn {
                                items(chat) {
                                    when (it.participant) {
                                        Participant.USER -> UserChatItem(prompt = it.prompt)
                                        Participant.MODEL -> ModelChatItem(response = it.prompt)
                                    }

                                }
                            }
                        }

                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = state.prompt,
                    enabled = state.isPromptEnabled,
                    onValueChange = onValueChangePrompt,
                    placeholder = { Text(text = "Type your prompt") },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                    )
                )
                IconButton(
                    onClick = onClickSubmit,
                    enabled = state.isActionEnabled
                ) {
                    Icon(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.send),
                        contentDescription = "Send button"
                    )
                }


            }

        }
    }
}