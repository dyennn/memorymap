package com.example.memorymap.controller.api

import com.example.memorymap.models.AuthResponse
import com.example.memorymap.models.LoginRequest
import com.example.memorymap.models.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

import retrofit2.http.POST


interface AuthApiService
{
    @POST("login.php")
    suspend fun login(@Body request : LoginRequest) : Response<AuthResponse>

    @POST("register.php")
    suspend fun register(@Body request : RegisterRequest) : Response<AuthResponse>

    @GET("logout.php")
    suspend fun logout() : Response<Unit>

    @GET("forgot_password.php")
    suspend fun forgotPassword() : Response<Unit>

    @GET("read.php")
    suspend fun read() : Response<Unit>
}
