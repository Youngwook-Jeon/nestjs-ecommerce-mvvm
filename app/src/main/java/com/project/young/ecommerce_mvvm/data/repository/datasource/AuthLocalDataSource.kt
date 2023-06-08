package com.project.young.ecommerce_mvvm.data.repository.datasource

import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}