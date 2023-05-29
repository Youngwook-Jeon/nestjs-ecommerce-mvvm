package com.project.young.ecommerce_mvvm.presentation.screens.client.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.project.young.ecommerce_mvvm.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.project.young.ecommerce_mvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ClientCategoryListScreen() {
    Scaffold() { paddingValues ->
        ClientCategoryListContent(paddingValues = paddingValues)
    }
}