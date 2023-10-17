package com.example.finalapp.domain.usecases.doors

import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.repositories.DoorRepository
import com.example.finalapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RefreshDoorsUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<DoorModel>>> {

        doorRepository.getRemoteDoors().collect { resource ->
            if (resource is Resource.Success) {
                if (doorRepository.getLocalDoors().isEmpty()) {
                    doorRepository.insertLocalDoors(resource.data!!)
                } else {
                    doorRepository.updateLocalDoors(resource.data!!)
                }
            }
        }
        return doorRepository.getRemoteDoors()
    }
}