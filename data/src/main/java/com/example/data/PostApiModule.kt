package com.example.data

import com.example.data.remote.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostApiModule {

   @Provides
   @Singleton
   fun provideApiService(retrofit: Retrofit) =retrofit.create(PostApiService::class.java)
}