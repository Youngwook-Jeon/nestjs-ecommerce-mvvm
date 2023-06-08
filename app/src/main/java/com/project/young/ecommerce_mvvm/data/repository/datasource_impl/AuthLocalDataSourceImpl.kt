package com.project.young.ecommerce_mvvm.data.repository.datasource_impl

import com.project.young.ecommerce_mvvm.data.datastore.AuthDatastore
import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthLocalDataSource
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore): AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun logout() = authDatastore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
}