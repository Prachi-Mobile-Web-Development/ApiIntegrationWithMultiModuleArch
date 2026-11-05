package com.example.mylibrary.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.domain.model.Post

@Composable
fun PostScreen(posts: List<Post>){
    LazyColumn() {
        items(items = posts, key = {it.id}){post->
            PostItem(post)
        }
    }

}

@Composable
fun PostItem(post: Post) {
    Column(){
        Text(text = post.title, style = MaterialTheme.typography.titleMedium)
        Text(text = post.body, style = MaterialTheme.typography.bodySmall)

    }
}