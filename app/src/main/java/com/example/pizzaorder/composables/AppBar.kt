package com.example.pizzaorder.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.pizzaorder.R
import com.example.pizzaorder.ui.theme.space16
import com.example.pizzaorder.ui.theme.text18

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(space16),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_back),
            contentDescription = stringResource(
                R.string.back_icon
            )
        )
        Text(text = stringResource(R.string.pizza), fontSize = text18, color = Color.Black,fontWeight= FontWeight.Black)
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_favorite),
            contentDescription = stringResource(
                R.string.favorites
            )
        )
    }
}