package com.project.young.ecommerce_mvvm.presentation.screens.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.project.young.ecommerce_mvvm.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navHostController: NavHostController) {
    Scaffold { paddingValues ->
        RolesContent(paddingValues)
    }
}