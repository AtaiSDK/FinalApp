package com.example.finalapp.data.repositories

import com.example.finalapp.data.models.Door
import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.repositories.CameraRepository
import com.example.finalapp.domain.repositories.DoorRepository

class DoorRepositoryImpl : DoorRepository {
    override suspend fun getAllDoors(): List<DoorModel> {
        TODO("Not yet implemented")
    }

    override suspend fun insertDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }
}