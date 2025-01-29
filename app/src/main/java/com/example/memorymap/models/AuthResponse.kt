package com.example.memorymap.models

data class AuthResponse(
        val status : String ,
        val message : String ,
        val user : UserData? ,
)

data class UserData(
        val id : Int ,
        val name : String ,
        val email : String ,
)