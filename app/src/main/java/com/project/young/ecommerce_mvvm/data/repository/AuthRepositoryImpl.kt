package com.project.young.ecommerce_mvvm.data.repository

import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthRemoteDataSource
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository
import com.project.young.ecommerce_mvvm.domain.util.Resource

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Resource.Success(result.body()!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

}