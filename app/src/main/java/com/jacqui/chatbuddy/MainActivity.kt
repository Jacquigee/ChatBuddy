package com.jacqui.chatbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jacqui.chatbuddy.presentation.ChatViewModel
import com.jacqui.chatbuddy.presentation.screen.ChatScreen
import com.jacqui.chatbuddy.presentation.theme.ChatBuddyTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatBuddyTheme {
                Scaffold(
                    content = { paddingValues ->
                        ChatScreen(
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize(),
                            viewModel = viewModel
                        )
                    }
                )

            }
        }
    }
}
