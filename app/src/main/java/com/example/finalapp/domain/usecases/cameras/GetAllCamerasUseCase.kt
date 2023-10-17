package com.example.finalapp.domain.usecases.cameras

import com.example.finalapp.domain.models.CameraModel
import com.example.finalapp.domain.repositories.CameraRepository
import com.example.finalapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<CameraModel>>> {
        val data = cameraRepository.getLocalCameras()
        if (data.isEmpty()) {
            cameraRepository.getRemoteCameras().collect {
                if (it is Resource.Success) {
                    cameraRepository.insertLocalCameras(it.data!!)
                }
            }
            return cameraRepository.getRemoteCameras()
        } else {
            return flow {
                emit(Resource.Success(data = data))
            }
        }
    }
}