package com.project.young.ecommerce_mvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.project.young.ecommerce_mvvm.domain.util.Resource
import com.project.young.ecommerce_mvvm.presentation.components.ProgressBar
import com.project.young.ecommerce_mvvm.presentation.navigation.graph.AuthScreen
import com.project.young.ecommerce_mvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navHostController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {
    when (val response = vm.registerResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navHostController.navigate(route = AuthScreen.Home.route)
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "에러가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}