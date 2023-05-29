package com.project.young.ecommerce_mvvm.presentation.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.project.young.ecommerce_mvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen() {
    Scaffold() { paddingValues ->
        ProfileContent(paddingValues = paddingValues)
    }
}