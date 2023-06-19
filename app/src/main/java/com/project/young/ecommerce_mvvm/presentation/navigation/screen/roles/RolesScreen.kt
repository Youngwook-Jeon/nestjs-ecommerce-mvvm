package com.project.young.ecommerce_mvvm.presentation.navigation.screen.roles

sealed class RolesScreen(val route: String) {

    object Roles: RolesScreen("roles")
}
