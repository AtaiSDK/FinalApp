package com.example.finalapp.di

import com.example.finalapp.data.repositories.CameraRepositoryImpl
import com.example.finalapp.data.repositories.DoorRepositoryImpl
import com.example.finalapp.domain.repositories.CameraRepository
import com.example.finalapp.domain.repositories.DoorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCameraRepository(cameraRepositoryImpl: CameraRepositoryImpl): CameraRepository

    @Binds
    fun bindDoorRepository(doorRepositoryImpl: DoorRepositoryImpl): DoorRepository
}