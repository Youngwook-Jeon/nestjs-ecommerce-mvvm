package com.project.young.ecommerce_mvvm.domain.model

data class AuthResponse(
    val user: User,
    val token: String
)
