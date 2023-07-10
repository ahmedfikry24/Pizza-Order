package com.example.pizzaorder.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.pizzaorder.ui.theme.lightGreen
import com.example.pizzaorder.ui.theme.size50
import com.example.pizzaorder.ui.theme.size70

@Composable
fun IngredientImage(imageId: Int, isSelected: Boolean, onClick: () -> Unit) {
    Box(Modifier.size(size70),contentAlignment = Alignment.Center) {
        AnimatedVisibility(visible = isSelected) {
            IngredientBackground()
        }
        Image(
            modifier = Modifier
                .size(size50)
                .clickable(onClick = onClick),
            painter = painterResource(imageId),
            contentDescription = "Ingredients"
        )
    }
}

@Composable
fun IngredientBackground() {
    Canvas(modifier = Modifier.size(size70)) {
        drawCircle(lightGreen)
    }
}