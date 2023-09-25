package com.example.finalapp.domain.repositories

import com.example.finalapp.data.models.Door
import com.example.finalapp.domain.models.DoorModel

interface DoorRepository {

    suspend fun getAllDoors(): List<DoorModel>

    suspend fun insertDoor(door: DoorModel) : Unit

    suspend fun updateDoor(door: DoorModel): Unit

    suspend fun deleteDoor(door: DoorModel) : Unit
}