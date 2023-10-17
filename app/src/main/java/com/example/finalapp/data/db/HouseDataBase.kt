package com.example.finalapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalapp.data.dtos.CameraDto
import com.example.finalapp.data.dtos.DoorDto
import com.example.finalapp.data.models.Camera
import com.example.finalapp.data.models.Door


@Database(entities = [CameraDto::class, DoorDto::class], version = 1, exportSchema = true)
abstract class HouseDatabase : RoomDatabase() {
    abstract fun getCameraDao(): CameraDao
    abstract fun getDoorDao(): DoorDao
}