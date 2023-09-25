package com.example.finalapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalapp.data.models.Camera
import com.example.finalapp.data.models.Door


@Database(entities = [Door::class, Camera::class], [], 1, true)
abstract class HouseDataBase : RoomDatabase() {

    abstract fun getCameraDao(): CameraDao

    abstract fun getDoorDao(): DoorDao
}