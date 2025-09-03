package com.example.receitafacil.ui.presentation.features.register.data.repository

import com.example.receitafacil.core.domain.model.SimpleResponseModel
import com.example.receitafacil.core.util.ServiceResult
import com.example.receitafacil.ui.presentation.features.register.domain.model.AddUserRequestModel
import com.example.receitafacil.ui.presentation.features.register.domain.repository.RegisterUserRepository
import com.example.receitafacil.ui.presentation.features.register.domain.source.RegisterUserRemoteDataSource
import javax.inject.Inject

class RegisterUserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RegisterUserRemoteDataSource
): RegisterUserRepository {

    override suspend fun registerUser(addUserRequestModel: AddUserRequestModel): ServiceResult<SimpleResponseModel> {
        return remoteDataSource.registerUser(addUserRequestModel)
    }
}