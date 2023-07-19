package com.example.pizzaorder.screens

import androidx.lifecycle.ViewModel
import com.example.pizzaorder.screens.uiState.PizzaSizeState
import com.example.pizzaorder.screens.uiState.PreparePizzaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PreparePizzaViewModel : ViewModel() {

    private val _state = MutableStateFlow(PreparePizzaUiState())
    val state = _state.asStateFlow()

    fun onClickIngredient(pizzaIndex: Int, ingredientIndex: Int) {
        val pizzaList = _state.value.pizza.toMutableList().apply {
            this[pizzaIndex] =
                this[pizzaIndex].copy(ingredients = this[pizzaIndex].ingredients.toMutableList()
                    .apply {
                        this[ingredientIndex] = this[ingredientIndex].copy(
                            isSelected = !_state.value.pizza[pizzaIndex].ingredients[ingredientIndex].isSelected
                        )
                    })
        }
        _state.update { it.copy(pizza = pizzaList) }
    }

    fun onClickSize(pizzaIndex: Int, state: PizzaSizeState) {
        _state.update {
            it.copy(
                pizza = _state.value.pizza.toMutableList().apply {
                    this[pizzaIndex] = this[pizzaIndex].copy(
                        size = state
                    )
                }
            )
        }
    }
}