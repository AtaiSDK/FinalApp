package com.example.finalapp.data.utils

import com.example.finalapp.data.utils.Constants.CONNECTION_ERROR
import com.example.finalapp.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class GetResource {
    protected suspend fun <T> getResult(result: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            val data = result()
            emit(Resource.Success(data))
        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.message ?: CONNECTION_ERROR))
        }
    }.flowOn(Dispatchers.IO)
}