package com.project.young.ecommerce_mvvm.presentation.screens.auth.register

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.young.ecommerce_mvvm.presentation.components.DefaultTopBar
import com.project.young.ecommerce_mvvm.presentation.screens.auth.register.components.RegisterContent
import com.project.young.ecommerce_mvvm.presentation.ui.theme.EcommercemvvmTheme

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "가입",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    EcommercemvvmTheme {
        RegisterScreen(rememberNavController())
    }
}