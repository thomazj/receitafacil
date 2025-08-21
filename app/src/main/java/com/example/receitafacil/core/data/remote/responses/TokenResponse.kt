package com.example.receitafacil.core.data.remote.responses

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("isSucessful")
    val isSucessful: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("userName")
    val userName: String
)