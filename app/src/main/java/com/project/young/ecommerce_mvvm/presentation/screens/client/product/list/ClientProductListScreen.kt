package com.project.young.ecommerce_mvvm.presentation.screens.client.product.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.project.young.ecommerce_mvvm.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen() {
    Scaffold() { paddingValues ->
        ClientProductListContent(paddingValues = paddingValues)
    }
}