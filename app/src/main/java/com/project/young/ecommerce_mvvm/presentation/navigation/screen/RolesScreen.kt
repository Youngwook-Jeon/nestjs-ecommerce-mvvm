package com.project.young.ecommerce_mvvm.presentation.navigation.screen

sealed class RolesScreen(val route: String) {

    object Roles: RolesScreen("roles")
}
