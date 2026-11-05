package com.example.data.remote

import com.example.data.dto.PostDto
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun fetchPosts():List<PostDto>
}