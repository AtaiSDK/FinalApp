package com.example.finalapp.data.db

import androidx.room.*
import com.example.finalapp.data.models.Door

@Dao
interface DoorDao {

    @Query("SELECT * FROM door")
    suspend fun getAllDoors(): List<Door>

    @Insert
    suspend fun insertDoor(door: Door) : Unit

    @Update
    suspend fun updateDoor(door: Door): Unit

    @Delete
    suspend fun deleteDoor(door: Door) : Unit


}