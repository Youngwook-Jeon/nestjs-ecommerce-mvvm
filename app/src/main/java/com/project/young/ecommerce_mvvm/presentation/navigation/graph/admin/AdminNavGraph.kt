package com.project.young.ecommerce_mvvm.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.young.ecommerce_mvvm.presentation.navigation.Graph
import com.project.young.ecommerce_mvvm.presentation.navigation.graph.profile.ProfileNavGraph
import com.project.young.ecommerce_mvvm.presentation.navigation.screen.admin.AdminScreen
import com.project.young.ecommerce_mvvm.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.project.young.ecommerce_mvvm.presentation.screens.admin.product.list.AdminProductListScreen
import com.project.young.ecommerce_mvvm.presentation.screens.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ) {
        composable(route = AdminScreen.ProductList.route) {
            AdminProductListScreen()
        }

        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen()
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen()
        }

        ProfileNavGraph(navController)
    }
}