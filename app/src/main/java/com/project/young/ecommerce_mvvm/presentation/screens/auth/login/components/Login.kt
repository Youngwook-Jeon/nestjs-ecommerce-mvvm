package com.project.young.ecommerce_mvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.project.young.ecommerce_mvvm.domain.util.Resource
import com.project.young.ecommerce_mvvm.presentation.components.ProgressBar
import com.project.young.ecommerce_mvvm.presentation.navigation.Graph
import com.project.young.ecommerce_mvvm.presentation.navigation.screen.AuthScreen
import com.project.young.ecommerce_mvvm.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navHostController: NavHostController, vm: LoginViewModel = hiltViewModel()) {
    when (val response = vm.loginResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                if (response.data.user?.roles!!.size > 1) {
                    navHostController.navigate(route = Graph.ROLES) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                } else {
                    navHostController.navigate(route = Graph.ROLES) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                }

            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "에러가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}