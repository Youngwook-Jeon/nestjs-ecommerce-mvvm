package com.project.young.ecommerce_mvvm.presentation.screens.roles

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.young.ecommerce_mvvm.domain.model.AuthResponse
import com.project.young.ecommerce_mvvm.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var authResponse by mutableStateOf(AuthResponse())

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            if (!data.token.isNullOrBlank()) {
                authResponse = data
            }
        }
    }
}