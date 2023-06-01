package com.project.young.ecommerce_mvvm.presentation.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object CategoryList : AdminScreen(
        route = "admin/category/list",
        title = "카테고리",
        icon = Icons.Default.List
    )
    object ProductList : AdminScreen(
        route = "admin/product/list",
        title = "제품",
        icon = Icons.Default.ThumbUp
    )
    object Profile : AdminScreen(
        route = "admin/profile",
        title = "프로필",
        icon = Icons.Default.Person
    )
}
