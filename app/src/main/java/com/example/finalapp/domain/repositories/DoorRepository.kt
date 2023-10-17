package com.example.finalapp.domain.repositories

import com.example.finalapp.data.models.Door
import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getRemoteDoors(): Flow<Resource<List<DoorModel>>>

    fun getLocalDoors(): List<DoorModel>

    fun insertDoor(doorModel: DoorModel)

    fun insertLocalDoors(doorModels: List<DoorModel>)

    fun updateDoor(doorModel: DoorModel)

    fun updateLocalDoors(doorModels: List<DoorModel>)

    fun deleteDoor(doorModel: DoorModel)
}