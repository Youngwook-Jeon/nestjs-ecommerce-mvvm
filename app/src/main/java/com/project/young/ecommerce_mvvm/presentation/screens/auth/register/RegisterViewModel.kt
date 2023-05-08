package com.project.young.ecommerce_mvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")
        private set

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

    fun validateForm() = viewModelScope.launch {
        if (state.name == "") {
            errorMessage = "이름을 입력하세요."
        }
        else if (state.lastname == "") {
            errorMessage = "성을 입력하세요."
        }
        else if (state.phone == "") {
            errorMessage = "휴대전화 번호를 입력하세요."
        }
        else if (state.email == "") {
            errorMessage = "이메일을 입력하세요."
        }
        else if (state.password == "") {
            errorMessage = "비밀번호를 입력하세요."
        }
        else if (state.confirmPassword == "") {
            errorMessage = "확인 비밀번호를 입력하세요."
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "올바른 이메일 형식이 아닙니다."
        }
        else if (state.password.length < 8) {
            errorMessage = "비밀번호는 최소 8자 이상이어야 합니다."
        }
        else if (state.password != state.confirmPassword) {
            errorMessage = "비밀번호가 일치하지 않습니다."
        }

        delay(3000)
        errorMessage = ""
    }
}