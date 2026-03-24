package com.jacqui.chatbuddy.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jacqui.chatbuddy.presentation.theme.ChatBuddyTheme

@Composable
fun UserChatItem(prompt: String) {
    Column(
        modifier = Modifier
            .padding(
                start = 100.dp,
                end = 5.dp,
                top = 5.dp,
                bottom = 16.dp
            )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp, 0.dp, 12.dp, 12.dp))
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            text = prompt,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun UserChatComponentPreview() {
    UserChatItem(prompt = "Hello Model")
}

// Theme
@Preview
@Composable
fun UserChatComponentTheme() {
    ChatBuddyTheme {
        UserChatItem(prompt = "Hello Model")
    }
}

// annotation parameters and App theme
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun UserChatComponentPreviewParams() {
    ChatBuddyTheme {
        UserChatItem(prompt = "Hello Model")
    }
}

// groups
@Preview(
    name = "Light Mode",
    group = "theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark Mode",
    group = "theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun UserChatComponentPreviewGroups() {
    ChatBuddyTheme {
        UserChatItem(prompt = "Hello Model")
    }
}

//MultiPreviews
@Preview(
    name = "Light Mode",
    group = "theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark Mode",
    group = "theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class PreviewTheme

@PreviewTheme
@Composable
fun UserChatComponentMultiPreviews() {
    ChatBuddyTheme {
        UserChatItem(prompt = "Hello Model")
    }
}