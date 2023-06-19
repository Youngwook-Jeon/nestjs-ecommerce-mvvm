package com.project.young.ecommerce_mvvm.presentation.screens.profile.update

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.project.young.ecommerce_mvvm.presentation.screens.profile.update.components.ProfileUpdateContent

@Composable
fun ProfileUpdateScreen(navController: NavHostController) {
    Scaffold() { paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }
}