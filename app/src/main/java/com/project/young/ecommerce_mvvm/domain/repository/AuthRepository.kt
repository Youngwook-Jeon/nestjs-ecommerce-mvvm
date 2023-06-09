package com.project.young.ecommerce_mvvm.domain.repository

import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.model.User
import com.project.young.ecommerce_mvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}