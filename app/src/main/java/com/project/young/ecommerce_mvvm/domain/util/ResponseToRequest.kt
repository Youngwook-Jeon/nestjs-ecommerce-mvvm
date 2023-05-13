package com.project.young.ecommerce_mvvm.domain.util

import com.project.young.ecommerce_mvvm.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result: Response<T>): Resource<T> {
        return try {
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