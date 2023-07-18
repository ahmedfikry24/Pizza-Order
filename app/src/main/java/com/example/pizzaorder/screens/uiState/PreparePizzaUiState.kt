package com.example.pizzaorder.screens.uiState

import com.example.pizzaorder.R

data class PreparePizzaUiState(
    val pizza: List<PizzaUiState> = listOf(
        PizzaUiState(
            R.drawable.bread_1,
            size = PizzaSizeUiState( state = PizzaSizeState.SMALL),
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, false),
                IngredientsUiState(R.drawable.onion_3, false),
                IngredientsUiState(R.drawable.broccoli_3, false),
                IngredientsUiState(R.drawable.mushroom_3, false),
                IngredientsUiState(R.drawable.sausage_3, false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_2,
            size = PizzaSizeUiState( state = PizzaSizeState.SMALL),
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, false),
                IngredientsUiState(R.drawable.onion_3, false),
                IngredientsUiState(R.drawable.broccoli_3, false),
                IngredientsUiState(R.drawable.mushroom_3, false),
                IngredientsUiState(R.drawable.sausage_3, false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_3,
            size = PizzaSizeUiState( state = PizzaSizeState.SMALL),
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, false),
                IngredientsUiState(R.drawable.onion_3, false),
                IngredientsUiState(R.drawable.broccoli_3, false),
                IngredientsUiState(R.drawable.mushroom_3, false),
                IngredientsUiState(R.drawable.sausage_3, false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_4,
            size = PizzaSizeUiState( state = PizzaSizeState.SMALL),
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, false),
                IngredientsUiState(R.drawable.onion_3, false),
                IngredientsUiState(R.drawable.broccoli_3, false),
                IngredientsUiState(R.drawable.mushroom_3, false),
                IngredientsUiState(R.drawable.sausage_3, false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_5,
            size = PizzaSizeUiState( state = PizzaSizeState.SMALL),
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, false),
                IngredientsUiState(R.drawable.onion_3, false),
                IngredientsUiState(R.drawable.broccoli_3, false),
                IngredientsUiState(R.drawable.mushroom_3, false),
                IngredientsUiState(R.drawable.sausage_3, false),
            ),
        ),
    ),
)

data class PizzaUiState(
    val bread: Int,
    val size: PizzaSizeUiState,
    val ingredients: List<IngredientsUiState>,
)

data class PizzaSizeUiState(
    val state: PizzaSizeState = PizzaSizeState.SMALL,
    val isSelected: Boolean = false,
)

data class IngredientsUiState(
    val ingredient: Int,
    var isSelected: Boolean = false
)

enum class PizzaSizeState {
    SMALL,
    MEDIUM,
    LARGE,
}