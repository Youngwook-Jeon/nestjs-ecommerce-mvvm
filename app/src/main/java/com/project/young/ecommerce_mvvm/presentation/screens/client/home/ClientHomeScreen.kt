package com.project.young.ecommerce_mvvm.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.young.ecommerce_mvvm.presentation.navigation.graph.ClientNavGraph
import com.project.young.ecommerce_mvvm.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController) }
    ) {  paddingValues ->
//        Box(modifier = Modifier.padding(paddingValues))
        ClientNavGraph(navController = navController)
    }
}