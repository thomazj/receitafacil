package com.example.receitafacil.core.data.remote

import com.example.receitafacil.core.data.remote.requests.AddUserRequest
import com.example.receitafacil.core.data.remote.requests.AuthUserRequest
import com.example.receitafacil.core.data.remote.responses.SimplesResponse
import com.example.receitafacil.core.data.remote.responses.TokenResponse
import com.example.receitafacil.core.data.remote.responses.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class RecipesServiceApiImpl @Inject constructor(
    private val client: HttpClient
): RecipesServiceApi {
    override suspend fun login(authUserRequest: AuthUserRequest): TokenResponse {
        val response = client.post("users/login") {
            contentType(ContentType.Application.Json)
            setBody(authUserRequest)
        }
        return response.body();
    }

    override suspend fun register(addUserRequest: AddUserRequest): SimplesResponse {
        val response = client.post("users/register") {
            contentType(ContentType.Application.Json)
            setBody(addUserRequest)
        }
        return response.body();
    }

    override suspend fun getProfileUser(): UserResponse {
        val response = client.get("users/profile") {
            contentType(ContentType.Application.Json)
        }
        return response.body();
    }
}