package com.example.pizzaorder.screens

import androidx.lifecycle.ViewModel
import com.example.pizzaorder.R
import com.example.pizzaorder.screens.uiState.IngredientsUiState
import com.example.pizzaorder.screens.uiState.PizzaUiState
import com.example.pizzaorder.screens.uiState.PreparePizzaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PreparePizzaViewModel : ViewModel() {

    private val _state = MutableStateFlow(PreparePizzaUiState())
    val state = _state.asStateFlow()

    init {
        initializePizza()
    }

    private fun initializePizza() {
        _state.update {
            it.copy(
                pizza = listOf(
                    PizzaUiState(
                        R.drawable.bread_1,
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
                        ingredients = listOf(
                            IngredientsUiState(R.drawable.basil_3, false),
                            IngredientsUiState(R.drawable.onion_3, false),
                            IngredientsUiState(R.drawable.broccoli_3, false),
                            IngredientsUiState(R.drawable.mushroom_3, false),
                            IngredientsUiState(R.drawable.sausage_3, false),
                        ),
                    ),
                )
            )
        }
    }

    fun onClickIngredient(pizzaIndex: Int, ingredientIndex: Int) {
        val pizzaList = _state.value.pizza.toMutableList().apply {
            this[pizzaIndex] = this[pizzaIndex].copy(
                ingredients = this[pizzaIndex].ingredients.toMutableList().apply {
                    this[ingredientIndex] = this[ingredientIndex].copy(
                        isSelected = !_state.value.pizza[pizzaIndex].ingredients[ingredientIndex].isSelected
                    )
                }
            )
        }
        _state.update { it.copy(pizza = pizzaList) }
    }


}