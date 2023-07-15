package com.example.pizzaorder.screens.uiState

data class PreparePizzaUiState(
    val pizza: List<PizzaUiState> = listOf(),
)

data class PizzaUiState(
    val bread: Int,
    val size: PizzaSize = PizzaSize.NOT_SELECT_YET,
    val ingredients: List<IngredientsUiState>,
)

data class IngredientsUiState(
    val ingredient: Int,
    var isSelected: Boolean
)

enum class PizzaSize {
    SMALL,
    MEDIUM,
    LARGE,
    NOT_SELECT_YET
}