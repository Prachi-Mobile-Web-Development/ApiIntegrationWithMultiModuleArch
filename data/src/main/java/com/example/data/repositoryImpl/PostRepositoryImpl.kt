package com.example.data.repositoryImpl

import com.example.data.mapper.toDomain
import com.example.data.remote.PostApiService
import com.example.domain.model.Post
import com.example.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val postApiService: PostApiService): PostRepository {
    override suspend fun fetchPosts(): Result<List<Post>> = try{
        val data=postApiService.fetchPosts().map { it.toDomain()}
            Result.success(data)
        }catch (e: Exception){
        Result.failure(e)
        }

}