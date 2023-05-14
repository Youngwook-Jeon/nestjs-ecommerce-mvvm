package com.project.young.ecommerce_mvvm.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.usecase.auth.AuthUseCase
import com.project.young.ecommerce_mvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            if (data != null) {
                Log.d("LoginViewModel", "Data: ${data.toJson()}")
            } else {
                Log.d("LoginViewModel", "Data: NULL")
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            loginResponse = Resource.Loading
            val result = authUseCase.login(state.email, state.password)
            loginResponse = result
            Log.d("LoginViewModel", "Response: $loginResponse")
        }

    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "올바른 이메일 형식이 아닙니다."
            return false
        }
        else if (state.password.length < 8) {
            errorMessage = "비밀번호는 최소 8자 이상이어야 합니다."
            return false
        }

        return true
    }
}