package com.example.pizzaorder.screens

import androidx.lifecycle.ViewModel
import com.example.pizzaorder.R
import com.example.pizzaorder.screens.uiState.IngredientModel
import com.example.pizzaorder.screens.uiState.PizzaModel
import com.example.pizzaorder.screens.uiState.PreparePizzaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PreparePizzaViewModel : ViewModel() {

    private val _state = MutableStateFlow(PreparePizzaUiState())
    val state = _state.asStateFlow()

    init {
        initialPizza()
    }

    private fun initialPizza() {
        _state.update {
            it.copy(
                pizza = listOf(
                    PizzaModel(
                        R.drawable.bread_1,
                        0,
                        listOf(
                            IngredientModel(R.drawable.basil_3, false),
                            IngredientModel(R.drawable.onion_3, false),
                            IngredientModel(R.drawable.broccoli_3, false),
                            IngredientModel(R.drawable.mushroom_3, false),
                            IngredientModel(R.drawable.sausage_3, false),
                        ),
                    ),
                    PizzaModel(
                        R.drawable.bread_2,
                        0,
                        listOf(
                            IngredientModel(R.drawable.basil_3, false),
                            IngredientModel(R.drawable.onion_3, false),
                            IngredientModel(R.drawable.broccoli_3, false),
                            IngredientModel(R.drawable.mushroom_3, false),
                            IngredientModel(R.drawable.sausage_3, false),
                        ),
                    ),
                    PizzaModel(
                        R.drawable.bread_3,
                        0,
                        listOf(
                            IngredientModel(R.drawable.basil_3, false),
                            IngredientModel(R.drawable.onion_3, false),
                            IngredientModel(R.drawable.broccoli_3, false),
                            IngredientModel(R.drawable.mushroom_3, false),
                            IngredientModel(R.drawable.sausage_3, false),
                        ),
                    ),
                    PizzaModel(
                        R.drawable.bread_4,
                        0,
                        listOf(
                            IngredientModel(R.drawable.basil_3, false),
                            IngredientModel(R.drawable.onion_3, false),
                            IngredientModel(R.drawable.broccoli_3, false),
                            IngredientModel(R.drawable.mushroom_3, false),
                            IngredientModel(R.drawable.sausage_3, false),
                        ),
                    ),
                    PizzaModel(
                        R.drawable.bread_5,
                        0,
                        listOf(
                            IngredientModel(R.drawable.basil_3, false),
                            IngredientModel(R.drawable.onion_3, false),
                            IngredientModel(R.drawable.broccoli_3, false),
                            IngredientModel(R.drawable.mushroom_3, false),
                            IngredientModel(R.drawable.sausage_3, false),
                        ),
                    ),
                )
            )
        }
    }

    fun onClickIngredient(pizzaId: Int, ingredientId: Int, isSelected: Boolean) {
        _state.update { currentState ->
            val updatedPizzaList = currentState.pizza.toMutableList()
            val pizzaIndex = updatedPizzaList.indexOfFirst { it.bread == pizzaId }
            if (pizzaIndex != -1) {
                val updatedIngredientList =
                    updatedPizzaList[pizzaIndex].ingredients.map { ingredient ->
                        if (ingredient.ingredient == ingredientId) {
                            ingredient.copy(isSelected = isSelected)
                        } else {
                            ingredient
                        }
                    }
                updatedPizzaList[pizzaIndex] =
                    updatedPizzaList[pizzaIndex].copy(ingredients = updatedIngredientList)
            }
            currentState.copy(pizza = updatedPizzaList)
        }
    }
}