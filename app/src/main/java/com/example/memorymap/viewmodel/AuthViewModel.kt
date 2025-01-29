package com.example.memorymap.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorymap.controller.api.RetrofitClient
import com.example.memorymap.models.AuthResponse
import com.example.memorymap.models.LoginRequest
import com.example.memorymap.models.RegisterRequest
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * ViewModel for handling authentication-related operations.
 */
class AuthViewModel : ViewModel() {

    private val _loginState = mutableStateOf<Resource<AuthResponse>>(Resource.Empty())
    val loginState: State<Resource<AuthResponse>> get() = _loginState

    private val _registerState = mutableStateOf<Resource<AuthResponse>>(Resource.Empty())
    val registerState: State<Resource<AuthResponse>> get() = _registerState

    /**
     * Initiates the login process.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     */
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = Resource.Loading()
            try {
                val response = RetrofitClient.authService.login(LoginRequest(email, password))
                handleAuthResponse(response, _loginState)
            } catch (e: Exception) {
                _loginState.value = Resource.Error(e.message ?: "Unknown error")
            }
        }
    }

    /**
     * Initiates the registration process.
     *
     * @param name The name of the user.
     * @param email The email address of the user.
     * @param password The password of the user.
     * @param confirmPassword The confirmation of the password.
     */
    fun register(name: String, email: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            _registerState.value = Resource.Loading()
            try {
                val response = RetrofitClient.authService.register(
                        RegisterRequest(name, email, password, confirmPassword)
                                                                  )
                handleAuthResponse(response, _registerState)
            } catch (e: Exception) {
                _registerState.value = Resource.Error(e.message ?: "Unknown error")
            }
        }
    }

    /**
     * Handles the authentication response.
     *
     * @param response The response from the authentication API.
     * @param state The state to update based on the response.
     */
    private fun handleAuthResponse(
            response: Response<AuthResponse>,
            state: MutableState<Resource<AuthResponse>>,
                                  ) {
        if (response.isSuccessful) {
            response.body()?.let {
                state.value = Resource.Success(it)
            } ?: run {
                state.value = Resource.Error("Empty response")
            }
        } else {
            state.value = Resource.Error("Error: ${response.code()}")
        }
    }
}

/**
 * Sealed class representing the state of a resource.
 *
 * @param T The type of the resource.
 * @param data The data of the resource.
 * @param message The message associated with the resource.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Empty<T> : Resource<T>()
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}