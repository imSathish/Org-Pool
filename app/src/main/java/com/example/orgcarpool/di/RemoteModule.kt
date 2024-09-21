package com.example.orgcarpool.di

import com.example.orgcarpool.data.remote.ApiService
import com.example.orgcarpool.data.remote.httpClientAndroid
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun provideApiService(): ApiService {
        return ApiService(httpClientAndroid)
    }

}