package com.project.young.ecommerce_mvvm.domain.repository

import com.project.young.ecommerce_mvvm.domain.model.User
import com.project.young.ecommerce_mvvm.domain.util.Response

interface AuthRepository {

    suspend fun login(email: String, password: String): Response<User>
}