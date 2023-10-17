package com.example.finalapp.domain.usecases.doors

import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.repositories.DoorRepository
import javax.inject.Inject

class InsertDoorUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    fun insertDoor(doorModel: DoorModel) = doorRepository.insertDoor(doorModel)
}