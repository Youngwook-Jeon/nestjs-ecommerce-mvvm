package com.project.young.ecommerce_mvvm.data.repository

import com.project.young.ecommerce_mvvm.data.repository.datasource.AuthRemoteDataSource
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.model.ErrorResponse
import com.project.young.ecommerce_mvvm.domain.repository.AuthRepository
import com.project.young.ecommerce_mvvm.domain.util.ConvertErrorBody
import com.project.young.ecommerce_mvvm.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            if (result.isSuccessful) {
                Resource.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "에러가 발생했습니다.")
            }

        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "에러가 발생했습니다.")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("인터넷 연결을 다시 확인하세요.")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "에러가 발생했습니다.")
        }
    }

}