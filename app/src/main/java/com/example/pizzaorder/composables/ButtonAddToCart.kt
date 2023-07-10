package com.example.pizzaorder.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.pizzaorder.R
import com.example.pizzaorder.ui.theme.brown
import com.example.pizzaorder.ui.theme.size168
import com.example.pizzaorder.ui.theme.size56
import com.example.pizzaorder.ui.theme.space16
import com.example.pizzaorder.ui.theme.space8
import com.example.pizzaorder.ui.theme.text16
import com.example.pizzaorder.ui.theme.white

@Composable
fun ButtonAddToCart() {
    TextButton(
        modifier = Modifier.size(size168, size56),
        onClick = {},
        colors = ButtonDefaults.buttonColors(brown),
        shape = RoundedCornerShape(space16),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_shopping_cart),
            contentDescription = "Add To Cart Button"
        )
        HorizontalSpacer(width = space8)
        Text(
            text = "Add To Cart",
            fontSize = text16,
            fontWeight = FontWeight.Medium,
            color = white
        )
    }
}