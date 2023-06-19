package com.project.young.ecommerce_mvvm.presentation.navigation.screen.profile

sealed class ProfileScreen(val route: String) {

    object ProfileUpdate: ProfileScreen("profile/update")
}
