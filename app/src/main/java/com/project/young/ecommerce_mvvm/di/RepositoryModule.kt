package com.project.young.ecommerce_mvvm.di

import com.project.young.ecommerce_mvvm.data.repository.AuthRepositoryImpl
import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthRemoteDataSource
import com.project.young.ecommerce_mvvm.data.repository.datasource_impl.AuthRemoteDataSourceImpl
import com.project.young.ecommerce_mvvm.data.service.AuthService
import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource)
}