package com.example.finalapp.domain.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.finalapp.data.models.Camera
import com.example.finalapp.data.models.Door
import com.example.finalapp.domain.models.CameraModel
import com.example.finalapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CameraRepository {

    suspend fun getRemoteCameras(): Flow<Resource<List<CameraModel>>>

    fun getLocalCameras(): List<CameraModel>

    fun insertCamera(cameraModel: CameraModel)

    fun insertLocalCameras(cameraModels: List<CameraModel>)

    fun updateCamera(cameraModel: CameraModel)

    fun updateLocalCameras(cameraModels: List<CameraModel>)

    fun deleteCamera(cameraModel: CameraModel)
}