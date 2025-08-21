package com.example.receitafacil.core.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("httpCode")
    val httpCode: Int,
    @SerializedName("message")
    val message: String,
)
