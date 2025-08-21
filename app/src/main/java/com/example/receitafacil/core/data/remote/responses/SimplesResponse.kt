package com.example.receitafacil.core.data.remote.responses

import com.google.gson.annotations.SerializedName

data class SimplesResponse(
    @SerializedName("isSucessful")
    val isSucessful: Boolean,
    @SerializedName("message")
    val message: String
)