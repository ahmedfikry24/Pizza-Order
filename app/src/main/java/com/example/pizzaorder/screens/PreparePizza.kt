package com.example.pizzaorder.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pizzaorder.R
import com.example.pizzaorder.composables.AppBar
import com.example.pizzaorder.composables.ButtonAddToCart
import com.example.pizzaorder.composables.HorizontalSpacer
import com.example.pizzaorder.composables.IngredientImage
import com.example.pizzaorder.composables.PizzaSize
import com.example.pizzaorder.composables.VerticalSpacer
import com.example.pizzaorder.screens.uiState.PreparePizzaUiState
import com.example.pizzaorder.ui.theme.size200
import com.example.pizzaorder.ui.theme.size250
import com.example.pizzaorder.ui.theme.space16
import com.example.pizzaorder.ui.theme.space20
import com.example.pizzaorder.ui.theme.space40
import com.example.pizzaorder.ui.theme.text14
import com.example.pizzaorder.ui.theme.text24
import com.example.pizzaorder.ui.theme.white87

@Composable
fun PreparePizzaScreen(
    padding: PaddingValues,
    viewModel: PreparePizzaViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    PreparePizzaContent(padding, state,viewModel::onClickIngredient)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreparePizzaContent(
    padding: PaddingValues,
    state: PreparePizzaUiState,
    onClickIngredient :(Boolean)-> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white87)
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar()
        VerticalSpacer(height = space16)
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.size(size250),
                painter = painterResource(R.drawable.plate),
                contentDescription = stringResource(R.string.plate)
            )
            HorizontalPager(pageCount = state.breads.size) {
                Image(
                    modifier = Modifier.size(size200),
                    painter = painterResource(state.breads[it]),
                    contentDescription = stringResource(R.string.pizza_bread)
                )
            }
        }
        VerticalSpacer(height = space16)
        Text(
            text = stringResource(R.string._17),
            fontSize = text24,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        VerticalSpacer(height = space16)
        Row {
            PizzaSize("S", isSelected = true) {}
            HorizontalSpacer(width = space16)
            PizzaSize("M", isSelected = false) {}
            HorizontalSpacer(width = space16)
            PizzaSize("L", isSelected = false) {}
        }
        VerticalSpacer(height = space40)
        Column(Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(start = space16),
                text = stringResource(R.string.customize_your_pizza),
                fontSize = text14,
                color = Color.LightGray,
                fontWeight = FontWeight.Medium
            )
            LazyRow(contentPadding = PaddingValues(space16)) {
                items(state.ingredients.size) {
                    var isSelected by remember { mutableStateOf(false) }
                    IngredientImage(
                        imageId = state.ingredients[it],
                        isSelected = state.isIngredientSelected[it],
                        onClick = { }
                    )
                    HorizontalSpacer(width = space20)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonAddToCart()
        Spacer(modifier = Modifier.weight(1f))
    }
}