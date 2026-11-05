package com.example.data.mapper

import com.example.data.dto.PostDto
import com.example.domain.model.Post

fun PostDto.toDomain(): Post = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)