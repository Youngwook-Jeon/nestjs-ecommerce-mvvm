package com.project.young.ecommerce_mvvm.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.project.young.ecommerce_mvvm.presentation.navigation.Graph
import com.project.young.ecommerce_mvvm.presentation.navigation.graph.auth.AuthNavGraph
import com.project.young.ecommerce_mvvm.presentation.navigation.graph.roles.RolesNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)
    }
}