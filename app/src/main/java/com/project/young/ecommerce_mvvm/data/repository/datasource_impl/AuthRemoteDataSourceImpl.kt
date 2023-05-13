package com.project.young.ecommerce_mvvm.data.repository.datasource_impl

import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthRemoteDataSource
import com.project.young.ecommerce_mvvm.data.service.AuthService
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)

    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
}