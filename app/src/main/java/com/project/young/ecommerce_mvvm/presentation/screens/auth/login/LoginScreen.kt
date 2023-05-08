package com.project.young.ecommerce_mvvm.presentation.screens.auth.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.young.ecommerce_mvvm.presentation.screens.auth.login.components.LoginContent
import com.project.young.ecommerce_mvvm.presentation.ui.theme.EcommercemvvmTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold(

    ) { paddingValues ->
        LoginContent(navController = navController, paddingValues = paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    EcommercemvvmTheme {
        LoginScreen(rememberNavController())
    }
}