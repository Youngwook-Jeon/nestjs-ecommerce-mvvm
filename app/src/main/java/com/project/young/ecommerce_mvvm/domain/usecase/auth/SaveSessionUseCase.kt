package com.project.young.ecommerce_mvvm.domain.usecase.auth

import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(authResponse: AuthResponse) = authRepository.saveSession(authResponse)
}