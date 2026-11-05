package com.example.mylibrary.presentation.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mylibrary.presentation.viewmodel.PostViewModel

@Composable
fun MainScreen(postViewModel: PostViewModel= hiltViewModel()) {
         val uiState by postViewModel.postUiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        postViewModel.fetchPost()
    }
    when(val post =uiState){
        UiState.Empty -> {
            Text("No Data")
        }
        is UiState.Error -> {
            Text("${post.throwable.message}")

        }
        UiState.Loading -> {
            CircularProgressIndicator()
        }
        is UiState.Success ->{
            PostScreen(post.data)
        }
    }
}