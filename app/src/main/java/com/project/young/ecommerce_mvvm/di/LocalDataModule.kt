package com.project.young.ecommerce_mvvm.di

import com.project.young.ecommerce_mvvm.data.datastore.AuthDatastore
import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthLocalDataSource
import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthRemoteDataSource
import com.project.young.ecommerce_mvvm.data.repository.datasource_impl.AuthLocalDataSourceImpl
import com.project.young.ecommerce_mvvm.data.repository.datasource_impl.AuthRemoteDataSourceImpl
import com.project.young.ecommerce_mvvm.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDatastore)
}