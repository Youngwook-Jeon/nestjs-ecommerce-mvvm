package com.project.young.ecommerce_mvvm.domain.usecase.auth

import com.project.young.ecommerce_mvvm.domain.model.User
import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository

class RegisterUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(user: User) = authRepository.register(user)
}