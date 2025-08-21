package com.example.receitafacil.core.data.remote.requests

import com.google.gson.annotations.SerializedName

data class AuthUserRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
