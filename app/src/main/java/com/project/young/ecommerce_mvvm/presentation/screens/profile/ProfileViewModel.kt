package com.project.young.ecommerce_mvvm.presentation.screens.profile

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.model.User
import com.project.young.ecommerce_mvvm.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            user = data.user
        }
    }

    fun logout() = viewModelScope.launch {
        authUseCase.logout()
    }
}