package com.bagi.playgrounduicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bagi.playgrounduicompose.ui.composeFunctions.Conversation
import com.bagi.playgrounduicompose.ui.composeFunctions.MyScreenContent
import com.bagi.playgrounduicompose.ui.theme.PlaygroundUIComposeTheme

data class Message(val author: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundUIComposeTheme {
                //Conversation(messages = SampleData.conversationSample)
                //MyScreenContent()
            }
        }
    }
}