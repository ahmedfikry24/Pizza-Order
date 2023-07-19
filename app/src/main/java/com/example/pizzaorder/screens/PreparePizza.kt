package com.example.pizzaorder.screens

import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pizzaorder.R
import com.example.pizzaorder.composables.AppBar
import com.example.pizzaorder.composables.ButtonAddToCart
import com.example.pizzaorder.composables.IngredientImage
import com.example.pizzaorder.composables.TextPizzaSize
import com.example.pizzaorder.composables.VerticalSpacer
import com.example.pizzaorder.screens.uiState.PizzaSizeState
import com.example.pizzaorder.screens.uiState.PreparePizzaUiState
import com.example.pizzaorder.ui.theme.size180
import com.example.pizzaorder.ui.theme.size230
import com.example.pizzaorder.ui.theme.size250
import com.example.pizzaorder.ui.theme.space16
import com.example.pizzaorder.ui.theme.space20
import com.example.pizzaorder.ui.theme.space40
import com.example.pizzaorder.ui.theme.space8
import com.example.pizzaorder.ui.theme.text14
import com.example.pizzaorder.ui.theme.text24
import com.example.pizzaorder.ui.theme.white87

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PreparePizzaScreen(
    padding: PaddingValues,
    viewModel: PreparePizzaViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    PreparePizzaContent(
        padding = padding,
        state = state,
        pagerState = pagerState,
        onClickIngredient = viewModel::onClickIngredient,
        onClickSize = viewModel::onClickSize
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun PreparePizzaContent(
    padding: PaddingValues,
    state: PreparePizzaUiState,
    pagerState: PagerState,
    onClickIngredient: (Int, Int) -> Unit,
    onClickSize: (Int, PizzaSizeState) -> Unit
) {

    val currentPage = pagerState.currentPage
    val size by animateFloatAsState(
        targetValue = when (state.pizza[currentPage].size) {
            PizzaSizeState.SMALL -> 0.85f
            PizzaSizeState.MEDIUM -> 0.95f
            PizzaSizeState.LARGE -> 1.05f
        }
    )

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
            HorizontalPager( modifier =Modifier.fillMaxWidth(),pageCount = state.pizza.size, state = pagerState) {
                Box(modifier = Modifier.scale(size), contentAlignment = Alignment.Center) {
                    Image(
                        modifier = Modifier.size(size230),
                        painter = painterResource(state.pizza[currentPage].bread),
                        contentDescription = stringResource(R.string.pizza_bread)
                    )
                    state.pizza[currentPage].ingredients.forEach {ingredient->
                        androidx.compose.animation.AnimatedVisibility(
                            visible = ingredient.isSelected && !pagerState.isScrollInProgress,
                            enter = scaleIn(initialScale = 3f) + fadeIn(),
                            exit = ExitTransition.None
                        ) {
                            Image(
                                modifier = Modifier.size(size180),
                                painter = painterResource(id = ingredient.ingredientGroup),
                                contentDescription = null,
                            )
                        }
                    }
                }
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
        Row(horizontalArrangement = Arrangement.spacedBy(space8)) {
            TextPizzaSize(
                text = "S",
                isSelected = state.pizza[currentPage].size == PizzaSizeState.SMALL,
                onClick = {
                    onClickSize(
                        currentPage,
                        PizzaSizeState.SMALL
                    )
                }
            )
            TextPizzaSize(
                text = "M",
                isSelected = state.pizza[currentPage].size == PizzaSizeState.MEDIUM,
                onClick = {
                    onClickSize(
                        currentPage,
                        PizzaSizeState.MEDIUM
                    )
                }
            )
            TextPizzaSize(
                text = "L",
                isSelected = state.pizza[currentPage].size == PizzaSizeState.LARGE,
                onClick = {
                    onClickSize(
                        currentPage,
                        PizzaSizeState.LARGE
                    )
                }
            )
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
            LazyRow(
                contentPadding = PaddingValues(space16),
                horizontalArrangement = Arrangement.spacedBy(space20)
            ) {
                items(state.pizza.size) {
                    IngredientImage(
                        imageId = state.pizza[currentPage].ingredients[it].ingredient,
                        isSelected = state.pizza[currentPage].ingredients[it].isSelected,
                        onClick = { onClickIngredient(currentPage, it) }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonAddToCart()
        Spacer(modifier = Modifier.weight(1f))
    }
}