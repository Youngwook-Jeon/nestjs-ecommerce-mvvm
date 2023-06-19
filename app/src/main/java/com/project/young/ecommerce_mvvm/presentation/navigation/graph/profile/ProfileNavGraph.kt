package com.project.young.ecommerce_mvvm.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.young.ecommerce_mvvm.presentation.navigation.Graph
import com.project.young.ecommerce_mvvm.presentation.navigation.screen.profile.ProfileScreen
import com.project.young.ecommerce_mvvm.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {
        composable(route = ProfileScreen.ProfileUpdate.route) {
            ProfileUpdateScreen(navController)
        }
    }
}