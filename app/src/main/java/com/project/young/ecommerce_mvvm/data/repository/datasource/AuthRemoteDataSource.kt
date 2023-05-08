package com.project.young.ecommerce_mvvm.data.repository.datasource

import com.project.young.ecommerce_mvvm.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<User>
}