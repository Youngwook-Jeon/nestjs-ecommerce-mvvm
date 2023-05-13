package com.project.young.ecommerce_mvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.model.User
import com.project.young.ecommerce_mvvm.domain.usecase.auth.AuthUseCase
import com.project.young.ecommerce_mvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    var errorMessage by mutableStateOf("")

    fun register() = viewModelScope.launch {
        if (isValidForm()) {
            val user = User(
                name = state.name,
                lastname = state.lastname,
                phone = state.phone,
                email = state.email,
                password = state.password
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result
        }
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String) {
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String) {
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String) {
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String) {
        state = state.copy(confirmPassword = input)
    }

    fun isValidForm(): Boolean {
        if (state.name == "") {
            errorMessage = "이름을 입력하세요."
            return false
        }
        else if (state.lastname == "") {
            errorMessage = "성을 입력하세요."
            return false
        }
        else if (state.phone == "") {
            errorMessage = "휴대전화 번호를 입력하세요."
            return false
        }
        else if (state.email == "") {
            errorMessage = "이메일을 입력하세요."
            return false
        }
        else if (state.password == "") {
            errorMessage = "비밀번호를 입력하세요."
            return false
        }
        else if (state.confirmPassword == "") {
            errorMessage = "확인 비밀번호를 입력하세요."
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "올바른 이메일 형식이 아닙니다."
            return false
        }
        else if (state.password.length < 8) {
            errorMessage = "비밀번호는 최소 8자 이상이어야 합니다."
            return false
        }
        else if (state.password != state.confirmPassword) {
            errorMessage = "비밀번호가 일치하지 않습니다."
            return false
        }

        return true
    }
}