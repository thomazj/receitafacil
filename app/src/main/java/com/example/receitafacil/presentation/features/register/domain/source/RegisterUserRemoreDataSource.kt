package com.example.receitafacil.presentation.features.register.domain.source

import com.example.receitafacil.core.domain.model.SimpleResponseModel
import com.example.receitafacil.core.util.ServiceResult
import com.example.receitafacil.presentation.features.register.domain.model.AddUserRequestModel

interface RegisterUserRemoreDataSource {
    suspend fun registerUser(addUserRequestModel: AddUserRequestModel): ServiceResult<SimpleResponseModel>
}