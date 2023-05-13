package com.project.young.ecommerce_mvvm.data.repository

import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthRemoteDataSource
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.model.ErrorResponse
import com.project.young.ecommerce_mvvm.domain.model.User
import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository
import com.project.young.ecommerce_mvvm.domain.util.ConvertErrorBody
import com.project.young.ecommerce_mvvm.domain.util.Resource
import com.project.young.ecommerce_mvvm.domain.util.ResponseToRequest
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

}