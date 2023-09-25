package com.example.finalapp.data.db

import androidx.room.*
import com.example.finalapp.data.models.Camera
import com.example.finalapp.data.models.Door

@Dao
interface CameraDao {

    @Query("SELECT * FROM camera")
    suspend fun getAllDoors(): List<Camera>

    @Insert
    suspend fun insertCamera(camera: Camera) : Unit

    @Update
    suspend fun updateCamera(camera: Camera): Unit

    @Delete
    suspend fun deleteCamera(camera: Camera) : Unit


}