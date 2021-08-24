package com.bagi.playgrounduicompose.ui.composeFunctions

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bagi.playgrounduicompose.Message
import com.bagi.playgrounduicompose.R
import com.bagi.playgrounduicompose.SampleData
import com.bagi.playgrounduicompose.ui.theme.PlaygroundUIComposeTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_rounded),
            contentDescription = "company logo",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))

        var isExpanded by remember { mutableStateOf(false) }
        /*val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )*/

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(5.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                //color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConversation() {
    PlaygroundUIComposeTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    PlaygroundUIComposeTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}