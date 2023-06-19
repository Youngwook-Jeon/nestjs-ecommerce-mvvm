package com.project.young.ecommerce_mvvm.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object CategoryList : ClientScreen(
        route = "client/category/list",
        title = "카테고리",
        icon = Icons.Default.List
    )
    object ProductList : ClientScreen(
        route = "client/product/list",
        title = "제품",
        icon = Icons.Default.ThumbUp
    )
    object Profile : ClientScreen(
        route = "client/profile",
        title = "프로필",
        icon = Icons.Default.Person
    )

    object ProfileUpdate : ClientScreen(
        route = "client/profile/update",
        title = "프로필",
        icon = Icons.Default.Person
    )
}
