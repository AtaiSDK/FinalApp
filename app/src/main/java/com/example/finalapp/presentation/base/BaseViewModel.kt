package com.example.finalapp.presentation.base

import androidx.lifecycle.ViewModel
import com.example.finalapp.domain.utils.Resource
import com.example.finalapp.presentation.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseViewModel : ViewModel() {

    protected suspend fun <T> collectData(useCase: suspend () -> Flow<Resource<T>>): UiState<T> {
        var value: UiState<T> = UiState.Loading()
        useCase().flowOn(Dispatchers.IO).collect { resource ->
            when (resource) {
                is Resource.Loading -> value = UiState.Loading()
                is Resource.Success -> {
                    val data = resource.data
                    value = if (data != null) {
                        UiState.Success(data = data)
                    } else {
                        UiState.Empty()
                    }
                }

                is Resource.Error -> value = UiState.Error(message = resource.message ?: "ERROR")
            }
        }
        return value
    }
}