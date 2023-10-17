package com.example.finalapp.domain.usecases.cameras

import com.example.finalapp.domain.models.CameraModel
import com.example.finalapp.domain.repositories.CameraRepository
import javax.inject.Inject

class UpdateCameraUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    fun updateCamera(cameraModel: CameraModel) = cameraRepository.updateCamera(cameraModel)
}