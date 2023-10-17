package com.example.finalapp.data.db

import androidx.room.*
import com.example.finalapp.data.dtos.DoorDto
import com.example.finalapp.data.models.Door

@Dao
interface DoorDao {

    @Query("SELECT * FROM door_table")
    fun getAllDoors(): List<DoorDto>

    @Insert
    fun insertDoor(door: DoorDto)

    @Insert
    fun insertAllDoors(doors: List<DoorDto>)

    @Update
    fun updateAllDoors(doors: List<DoorDto>)

    @Update
    fun updateDoor(door: DoorDto)

    @Delete
    fun deleteDoor(door: DoorDto)
}