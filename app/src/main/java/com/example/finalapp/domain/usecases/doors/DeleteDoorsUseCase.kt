package com.example.finalapp.domain.usecases.doors

import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.repositories.DoorRepository
import javax.inject.Inject

class DeleteDoorUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    fun deleteDoor(doorModel: DoorModel) = doorRepository.deleteDoor(doorModel)
}