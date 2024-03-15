package com.jacqui.chatbuddy.presentation.components

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

@Composable
fun UserChatItem(prompt: String) {
    Column(modifier = Modifier.padding(start = 100.dp, end = 5.dp, top = 5.dp, bottom = 16.dp)) {
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun UserChatComponentPreview(){
    UserChatItem(prompt = "Hello Model")
}
