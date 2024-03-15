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
fun ModelChatItem(response: String) {
    Column(modifier = Modifier.padding(start = 5.dp, end = 100.dp, top = 5.dp, bottom = 16.dp)) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(0.dp, 12.dp,12.dp, 12.dp))
                .background(color = MaterialTheme.colorScheme.tertiary)
                .padding(16.dp),
            text = response,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onTertiary
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ModelChatComponentPreview(){
    ModelChatItem(response = "Hello there")
}
