package com.example.intempus.di

import com.example.intempus.data.network.MockDateAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideDateAPI(): MockDateAPI = MockDateAPI()
}