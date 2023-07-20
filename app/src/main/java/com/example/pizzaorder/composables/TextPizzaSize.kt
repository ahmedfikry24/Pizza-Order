package com.example.pizzaorder.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.pizzaorder.ui.theme.text18

@Composable
fun TextPizzaSize(text: String, onClick: () -> Unit) {
    Text(
        modifier = Modifier.clickable(
            onClick = onClick,
            interactionSource = MutableInteractionSource(),
            indication = null
        ),
        text = text, fontSize = text18, color = Color.Black, fontWeight = FontWeight.Medium
    )
}