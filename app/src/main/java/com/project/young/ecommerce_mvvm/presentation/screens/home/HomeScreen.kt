package com.project.young.ecommerce_mvvm.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Scaffold() { paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues = paddingValues),
            text = "HomeScreen"
        )
    }
}