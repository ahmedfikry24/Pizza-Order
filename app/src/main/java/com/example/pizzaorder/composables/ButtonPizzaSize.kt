package com.example.pizzaorder.composables

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.pizzaorder.ui.theme.size50
import com.example.pizzaorder.ui.theme.space4
import com.example.pizzaorder.ui.theme.text18
import com.example.pizzaorder.ui.theme.white

@Composable
fun ButtonPizzaSize(text: String, isSelected: Boolean, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.size(size50),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(white),
        elevation = if (isSelected) ButtonDefaults.buttonElevation(space4) else ButtonDefaults.buttonElevation()
    ) {
            Text(
                text = text, fontSize = text18, color = Color.Black, fontWeight = FontWeight.Medium
            )
    }
}