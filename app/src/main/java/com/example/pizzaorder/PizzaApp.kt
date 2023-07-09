package com.example.pizzaorder

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.pizzaorder.screens.PreparePizzaScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaApp() {
    Scaffold{ padding->
        PreparePizzaScreen(padding)
    }
}