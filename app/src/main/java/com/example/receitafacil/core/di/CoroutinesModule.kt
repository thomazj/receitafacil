package com.example.receitafacil.core.di

import com.example.receitafacil.core.util.DispatcherProvider
import com.example.receitafacil.core.util.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoroutinesModule {
    @Binds
    fun provideDispatcherProvider(dispatcherProvider: DispatcherProviderImpl): DispatcherProvider
}