package com.example.receitafacil.ui.presentation.features.register.data.source

import com.example.receitafacil.core.data.remote.RecipesServiceApi
import com.example.receitafacil.core.domain.exceptions.ErrorResponseException
import com.example.receitafacil.core.domain.model.SimpleResponseModel
import com.example.receitafacil.core.util.ServiceResult
import com.example.receitafacil.ui.presentation.features.register.data.mapper.toAddUserRequest
import com.example.receitafacil.ui.presentation.features.register.data.mapper.toSimpleResponseModel
import com.example.receitafacil.ui.presentation.features.register.domain.model.AddUserRequestModel
import com.example.receitafacil.ui.presentation.features.register.domain.source.RegisterUserRemoteDataSource
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import javax.inject.Inject

class RegisterUserRemoteDataSourceImpl @Inject constructor(
    private val recipesServiceApi: RecipesServiceApi
): RegisterUserRemoteDataSource {

    override suspend fun registerUser(
        addUserRequestModel: AddUserRequestModel
    ): ServiceResult<SimpleResponseModel> {
        return try {
            val addUserRequest = addUserRequestModel.toAddUserRequest()
            val response = recipesServiceApi.register(addUserRequest)
            if(response.isSucessful) {
                ServiceResult.Success(
                    response.toSimpleResponseModel()
                )
            } else {
                ServiceResult.Error(
                    message = response.message
                )
            }
        } catch (e: RedirectResponseException) {
            ServiceResult.Error(
                e.response.status.value.toString(),
                e.response.status.description
            )
        } catch (e: ClientRequestException) {
            ServiceResult.Error(
                e.response.status.value.toString(),
                e.response.status.description
            )
        } catch (e: ServerResponseException) {
            ServiceResult.Error(
                e.response.status.value.toString(),
                e.response.status.description
            )
        } catch (e: ErrorResponseException) {
            ServiceResult.Error(
                code = e.error.httpCode.toString(),
                message = e.error.message
            )
        } catch (e: Exception) {
            ServiceResult.Error(
                message = e.message.toString()
            )
        }
    }
}