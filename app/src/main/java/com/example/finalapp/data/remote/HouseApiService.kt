package com.example.finalapp.data.remote

import com.example.finalapp.data.dtos.CamerasDto
import com.example.finalapp.data.dtos.DoorsDto
import retrofit2.Response
import retrofit2.http.GET

interface HouseApiService {

    @GET("cameras/")
    suspend fun getCamera(): Response<CamerasDto>

    @GET("doors/")
    suspend fun getDoor(): Response<DoorsDto>
}