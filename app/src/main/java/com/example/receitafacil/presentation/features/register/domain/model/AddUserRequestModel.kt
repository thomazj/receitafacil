package com.example.receitafacil.presentation.features.register.domain.model

import com.google.gson.annotations.SerializedName

data class AddUserRequestModel(
    val name: String,
    val email: String,
    val password: String,
    val phone: String
)