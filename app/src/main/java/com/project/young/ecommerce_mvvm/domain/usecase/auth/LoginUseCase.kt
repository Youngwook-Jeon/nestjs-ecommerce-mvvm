package com.project.young.ecommerce_mvvm.domain.usecase.auth

import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = authRepository.login(email, password)
}