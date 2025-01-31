package com.example.memorymap.controller.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//192.168.92.149 - Deaniel's Address
//192.168.100.98 - Home Address
object RetrofitClient {
    private const val BASE_URL = "http://192.168.92.149/memorymap/api/auth/"

    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    }
    val authService : AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }
}