package com.project.young.ecommerce_mvvm.data.repository

import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthLocalDataSource
import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthRemoteDataSource
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.model.User
import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository
import com.project.young.ecommerce_mvvm.domain.util.Resource
import com.project.young.ecommerce_mvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}