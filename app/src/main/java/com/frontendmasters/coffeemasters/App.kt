package com.frontendmasters.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.frontendmasters.coffeemasters.pages.InfoPage
import com.frontendmasters.coffeemasters.pages.MenuPage
import com.frontendmasters.coffeemasters.pages.OrderPage
import com.frontendmasters.coffeemasters.ui.theme.CoffeeMastersTheme

@Preview
@Composable
fun App_Preview() {
    CoffeeMastersTheme {
        App()
    }
}

@Composable
fun App() {
    var selectedRoute = remember {
        mutableStateOf("menu")
    }
    Scaffold(
        topBar = {
            TopAppBar() {
                AppTitle()
            }
        },
        content = {
          when(selectedRoute.value) {
              Routes.MenuPage.route -> MenuPage()
              Routes.OffersPage.route -> OffersPage()
              Routes.OrderPage.route -> OrderPage()
              Routes.InfoPage.route -> InfoPage()
          }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = {
                    selectedRoute.value = it
            })
        })
}


@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo")
    }
}