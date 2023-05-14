package com.project.young.ecommerce_mvvm.domain.usecase.auth

import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val authRepository: AuthRepository) {

    operator fun invoke() = authRepository.getSessionData()
}