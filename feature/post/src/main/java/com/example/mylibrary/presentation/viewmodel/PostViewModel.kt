package com.example.mylibrary.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Post
import com.example.domain.usecase.PostUseCase
import com.example.mylibrary.presentation.screens.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postUseCase: PostUseCase): ViewModel() {
      private val _postUiState = MutableStateFlow<UiState<List<Post>>>(UiState.Empty)
      val postUiState=_postUiState.asStateFlow()

    fun fetchPost(){
        viewModelScope.launch {
            postUseCase().onSuccess { data->
                if(data.isEmpty()){
                    _postUiState.update { UiState.Empty }
                }
                else{
                    _postUiState.update { UiState.Success(data) }
                }

            }.onFailure {e->
                _postUiState.update { UiState.Error(e) }
            }
        }
    }
}