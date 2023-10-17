package com.example.finalapp.domain.usecases.cameras

import com.example.finalapp.domain.models.CameraModel
import com.example.finalapp.domain.repositories.CameraRepository
import com.example.finalapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RefreshCamerasUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<CameraModel>>> {

        cameraRepository.getRemoteCameras().collect { resource ->
            if (resource is Resource.Success) {
                if (cameraRepository.getLocalCameras().isEmpty()) {
                    cameraRepository.insertLocalCameras(resource.data!!)
                } else {
                    cameraRepository.updateLocalCameras(resource.data!!)
                }
            }
        }
        return cameraRepository.getRemoteCameras()
    }
}