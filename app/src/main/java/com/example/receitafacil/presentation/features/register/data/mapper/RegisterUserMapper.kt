package com.example.receitafacil.presentation.features.register.data.mapper

import com.example.receitafacil.core.data.remote.requests.AddUserRequest
import com.example.receitafacil.core.data.remote.responses.SimplesResponse
import com.example.receitafacil.core.domain.model.SimpleResponseModel
import com.example.receitafacil.presentation.features.register.domain.model.AddUserRequestModel

fun AddUserRequestModel.toAddUserRequest(): AddUserRequest{
    return AddUserRequest(
        name,
        email,
        password,
        phone
    )
}

fun SimplesResponse.toSimpleResponseModel(): SimpleResponseModel {
    return SimpleResponseModel(
        isSucessful,
        message
    )
}