package com.example.data

import com.example.data.repositoryImpl.PostRepositoryImpl
import com.example.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepositoryModule(postRepositoryImpl: PostRepositoryImpl): PostRepository
}