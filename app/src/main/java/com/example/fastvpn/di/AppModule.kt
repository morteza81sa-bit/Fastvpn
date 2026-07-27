package com.example.fastvpn.di

import com.example.fastvpn.data.ServerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideServerRepository(): ServerRepository {
        return ServerRepository()
    }
}