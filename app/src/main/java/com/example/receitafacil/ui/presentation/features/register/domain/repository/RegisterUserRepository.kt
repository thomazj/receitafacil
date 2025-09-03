package com.example.receitafacil.ui.presentation.features.register.domain.repository

import com.example.receitafacil.core.domain.model.SimpleResponseModel
import com.example.receitafacil.core.util.ServiceResult
import com.example.receitafacil.ui.presentation.features.register.domain.model.AddUserRequestModel

interface RegisterUserRepository {
    suspend fun registerUser(addUserRequestModel: AddUserRequestModel): ServiceResult<SimpleResponseModel>
}