package com.project.young.ecommerce_mvvm.presentation.screens.admin.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.project.young.ecommerce_mvvm.presentation.screens.admin.category.list.components.AdminCategoryListContent

@Composable
fun AdminCategoryListScreen() {
    Scaffold() { paddingValues ->
        AdminCategoryListContent(paddingValues = paddingValues)
    }
}