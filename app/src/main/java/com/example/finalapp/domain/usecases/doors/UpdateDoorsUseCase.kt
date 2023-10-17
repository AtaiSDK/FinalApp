package com.example.finalapp.domain.usecases.doors

import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.repositories.DoorRepository
import javax.inject.Inject

class UpdateDoorUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    fun updateDoor(doorModel: DoorModel) = doorRepository.updateDoor(doorModel)
}