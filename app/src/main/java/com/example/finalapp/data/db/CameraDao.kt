package com.example.finalapp.data.db

import androidx.room.*
import com.example.finalapp.data.dtos.CameraDto
import com.example.finalapp.data.models.Camera
import com.example.finalapp.data.models.Door

@Dao
interface CameraDao {

    @Query("SELECT * FROM camera_table")
    fun getAllCameras(): List<CameraDto>

    @Insert
    fun insertCamera(camera: CameraDto)

    @Insert
    fun insertAllCameras(cameras: List<CameraDto>)

    @Update
    fun updateCamera(camera: CameraDto)

    @Update
    fun updateAllCameras(cameras: List<CameraDto>)

    @Delete
    fun deleteCamera(camera: CameraDto)
}