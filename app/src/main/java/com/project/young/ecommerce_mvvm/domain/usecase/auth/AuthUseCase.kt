package com.project.young.ecommerce_mvvm.domain.usecase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
)
