package com.example.domain.usecase

import com.example.domain.repository.PostRepository
import javax.inject.Inject

class PostUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend operator fun invoke() =
        postRepository.fetchPosts()

}