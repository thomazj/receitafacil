package com.example.receitafacil.core.data.remote

import com.example.receitafacil.core.data.remote.requests.AddUserRequest
import com.example.receitafacil.core.data.remote.requests.AuthUserRequest
import com.example.receitafacil.core.data.remote.responses.SimplesResponse
import com.example.receitafacil.core.data.remote.responses.TokenResponse
import com.example.receitafacil.core.data.remote.responses.UserResponse

interface RecipesServiceApi {
    suspend fun login(authUserRequest: AuthUserRequest): TokenResponse
    suspend fun register(addUserRequest: AddUserRequest): SimplesResponse
    suspend fun getProfileUser(): UserResponse
}