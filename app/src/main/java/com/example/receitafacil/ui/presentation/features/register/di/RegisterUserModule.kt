package com.example.receitafacil.ui.presentation.features.register.di

import com.example.receitafacil.core.data.remote.RecipesServiceApi
import com.example.receitafacil.ui.presentation.features.register.data.repository.RegisterUserRepositoryImpl
import com.example.receitafacil.ui.presentation.features.register.data.source.RegisterUserRemoteDataSourceImpl
import com.example.receitafacil.ui.presentation.features.register.domain.repository.RegisterUserRepository
import com.example.receitafacil.ui.presentation.features.register.domain.source.RegisterUserRemoteDataSource
import com.example.receitafacil.ui.presentation.features.register.domain.usecase.ValidateRegisterInputUseCase
import com.example.receitafacil.ui.presentation.features.register.domain.usecase.ValidateRegisterInputUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterUserModule {

    @Provides
    @Singleton
    fun provideRegisterUserDataSource(
        recipesServiceApi: RecipesServiceApi
    ): RegisterUserRemoteDataSource {
        return RegisterUserRemoteDataSourceImpl(
            recipesServiceApi = recipesServiceApi
        )
    }

    @Provides
    @Singleton
    fun provideRegisterUserRepository(
        registerUserRemoteDataSource: RegisterUserRemoteDataSource
    ): RegisterUserRepository {
        return RegisterUserRepositoryImpl(
            remoteDataSource = registerUserRemoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideValidateRegisterInputUseCase(): ValidateRegisterInputUseCase {
        return ValidateRegisterInputUseCaseImpl()
    }
}
