package com.project.young.ecommerce_mvvm.presentation.screens.admin.product.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.project.young.ecommerce_mvvm.presentation.screens.admin.product.list.components.AdminProductListContent

@Composable
fun AdminProductListScreen() {
    Scaffold() { paddingValues ->
        AdminProductListContent(paddingValues = paddingValues)
    }
}