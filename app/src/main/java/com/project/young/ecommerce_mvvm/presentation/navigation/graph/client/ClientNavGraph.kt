package com.project.young.ecommerce_mvvm.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.young.ecommerce_mvvm.presentation.navigation.Graph
import com.project.young.ecommerce_mvvm.presentation.navigation.graph.profile.ProfileNavGraph
import com.project.young.ecommerce_mvvm.presentation.navigation.screen.client.ClientScreen
import com.project.young.ecommerce_mvvm.presentation.screens.client.category.list.ClientCategoryListScreen
import com.project.young.ecommerce_mvvm.presentation.screens.client.product.list.ClientProductListScreen
import com.project.young.ecommerce_mvvm.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {
        composable(route = ClientScreen.ProductList.route) {
            ClientProductListScreen()
        }

        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen()
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen()
        }

        ProfileNavGraph(navController)
    }
}