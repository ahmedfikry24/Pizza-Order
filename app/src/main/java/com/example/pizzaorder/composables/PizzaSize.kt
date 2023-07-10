package com.example.pizzaorder.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.ui.theme.size50
import com.example.pizzaorder.ui.theme.text18
import com.example.pizzaorder.ui.theme.white

@Composable
fun PizzaSize( text:String ,isSelected: Boolean, onClick: () -> Unit) {
    val modifier = if (isSelected) Modifier
        .size(size50)
        .background(white, CircleShape)
        .border(.5.dp, Color.Gray, CircleShape)
        .clickable(onClick = onClick) else Modifier.size(size50)
        .background(white, CircleShape).clickable(onClick = onClick)
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, fontSize = text18, color = Color.Black, fontWeight = FontWeight.Medium
        )
    }
}