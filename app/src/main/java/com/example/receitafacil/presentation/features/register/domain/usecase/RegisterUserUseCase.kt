package com.example.receitafacil.presentation.features.register.domain.usecase

import com.example.receitafacil.core.domain.model.SimpleResponseModel
import com.example.receitafacil.core.util.DispatcherProvider
import com.example.receitafacil.core.util.ResponseData
import com.example.receitafacil.core.util.ServiceResult
import com.example.receitafacil.core.util.Task
import com.example.receitafacil.presentation.features.register.domain.model.AddUserRequestModel
import com.example.receitafacil.presentation.features.register.domain.repository.RegisterUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface RegisterUserUseCase {
    operator fun invoke(parameters: Parameters): Flow<ResponseData<SimpleResponseModel>>
    data class Parameters(val addUserRequestModel: AddUserRequestModel)
}

class RegisterUserUseCaseImpl(
    private val registerUserRepository: RegisterUserRepository,
    private val dispatcherProvider: DispatcherProvider
): RegisterUserUseCase, Task<RegisterUserUseCase.Parameters, SimpleResponseModel>() {
    override suspend fun executeTask(parameters: RegisterUserUseCase.Parameters): ResponseData<SimpleResponseModel> {
        return try {
            withContext(dispatcherProvider.io()) {
                when(val response = registerUserRepository.registerUser(parameters.addUserRequestModel)) {
                    is ServiceResult.Success -> {
                        ResponseData.Success(response.data)
                    }
                    is ServiceResult.Error -> {
                        ResponseData.Error(Throwable(response.message))
                    }
                }
            }
        } catch (e: Exception) {
            ResponseData.Error(e)
        }
    }

}