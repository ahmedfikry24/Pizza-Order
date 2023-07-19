package com.example.pizzaorder.screens.uiState

import com.example.pizzaorder.R

data class PreparePizzaUiState(
    val pizza: List<PizzaUiState> = listOf(
        PizzaUiState(
            R.drawable.bread_1,
            size =  PizzaSizeState.SMALL,
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, R.drawable.group_basil,false),
                IngredientsUiState(R.drawable.onion_3, R.drawable.group_onion,false),
                IngredientsUiState(R.drawable.broccoli_3, R.drawable.group_broccoli,false),
                IngredientsUiState(R.drawable.mushroom_3,R.drawable.group_mushroom, false),
                IngredientsUiState(R.drawable.sausage_3, R.drawable.group_sausage,false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_2,
            size =  PizzaSizeState.SMALL,
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, R.drawable.group_basil,false),
                IngredientsUiState(R.drawable.onion_3, R.drawable.group_onion,false),
                IngredientsUiState(R.drawable.broccoli_3, R.drawable.group_broccoli,false),
                IngredientsUiState(R.drawable.mushroom_3,R.drawable.group_mushroom, false),
                IngredientsUiState(R.drawable.sausage_3, R.drawable.group_sausage,false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_3,
            size =  PizzaSizeState.SMALL,
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, R.drawable.group_basil,false),
                IngredientsUiState(R.drawable.onion_3, R.drawable.group_onion,false),
                IngredientsUiState(R.drawable.broccoli_3, R.drawable.group_broccoli,false),
                IngredientsUiState(R.drawable.mushroom_3,R.drawable.group_mushroom, false),
                IngredientsUiState(R.drawable.sausage_3, R.drawable.group_sausage,false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_4,
            size =  PizzaSizeState.SMALL,
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, R.drawable.group_basil,false),
                IngredientsUiState(R.drawable.onion_3, R.drawable.group_onion,false),
                IngredientsUiState(R.drawable.broccoli_3, R.drawable.group_broccoli,false),
                IngredientsUiState(R.drawable.mushroom_3,R.drawable.group_mushroom, false),
                IngredientsUiState(R.drawable.sausage_3, R.drawable.group_sausage,false),
            ),
        ),
        PizzaUiState(
            R.drawable.bread_5,
            size =  PizzaSizeState.SMALL,
            ingredients = listOf(
                IngredientsUiState(R.drawable.basil_3, R.drawable.group_basil,false),
                IngredientsUiState(R.drawable.onion_3, R.drawable.group_onion,false),
                IngredientsUiState(R.drawable.broccoli_3, R.drawable.group_broccoli,false),
                IngredientsUiState(R.drawable.mushroom_3,R.drawable.group_mushroom, false),
                IngredientsUiState(R.drawable.sausage_3, R.drawable.group_sausage,false),
            ),
        ),
    ),
)

data class PizzaUiState(
    val bread: Int,
    val size: PizzaSizeState,
    val ingredients: List<IngredientsUiState>,
)

data class IngredientsUiState(
    val ingredient: Int,
    val ingredientGroup:Int,
    var isSelected: Boolean = false
)

enum class PizzaSizeState {
    SMALL,
    MEDIUM,
    LARGE,
}