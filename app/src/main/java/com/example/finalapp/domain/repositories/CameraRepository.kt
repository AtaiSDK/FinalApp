package com.example.finalapp.domain.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.finalapp.data.models.Camera
import com.example.finalapp.data.models.Door
import com.example.finalapp.domain.models.CameraModel

interface CameraRepository {

    suspend fun getAllDoors(): List<CameraModel>

    suspend fun insertCamera(camera: CameraModel) : Unit

    suspend fun updateCamera(camera: CameraModel): Unit

    suspend fun deleteCamera(camera: CameraModel) : Unit



}