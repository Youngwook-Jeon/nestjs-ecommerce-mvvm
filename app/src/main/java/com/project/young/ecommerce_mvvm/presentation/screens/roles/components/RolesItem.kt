package com.project.young.ecommerce_mvvm.presentation.screens.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.project.young.ecommerce_mvvm.domain.model.Role
import com.project.young.ecommerce_mvvm.presentation.navigation.screen.AuthScreen

@Composable
fun RolesItem(role: Role, navHostController: NavHostController) {
    Column(modifier = Modifier.clickable {
//        navHostController.navigate(route = role.route) {
//            popUpTo(route = AuthScreen.Roles.route) { inclusive = true }
//        }
    }) {
        Spacer(modifier = Modifier.height(20.dp))
        AsyncImage(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp),
            model = role.image,
            contentDescription = "",
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = role.name,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
    }
}