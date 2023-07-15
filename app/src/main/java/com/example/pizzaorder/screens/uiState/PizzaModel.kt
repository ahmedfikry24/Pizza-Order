package com.example.pizzaorder.screens.uiState

data class PizzaModel(
    val bread: Int,
    val size: Int,
    val ingredients: List<IngredientModel>,
)
