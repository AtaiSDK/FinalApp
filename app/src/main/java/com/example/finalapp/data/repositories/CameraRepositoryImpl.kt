package com.example.finalapp.data.repositories

import com.example.finalapp.data.db.CameraDao
import com.example.finalapp.data.dtos.toDataDto
import com.example.finalapp.data.dtos.toDomainModel
import com.example.finalapp.data.remote.HouseApiService
import com.example.finalapp.data.utils.GetResource
import com.example.finalapp.domain.models.CameraModel
import com.example.finalapp.domain.repositories.CameraRepository
import com.example.finalapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val dao: CameraDao,
    private val houseApiService: HouseApiService,
) : CameraRepository, GetResource() {
    override suspend fun getRemoteCameras() = getResult {
        houseApiService.getCamera().body()!!.data.cameras.toDomainModel()
    }

    override fun getLocalCameras(): List<CameraModel> {
        return dao.getAllCameras().toDomainModel()
    }

    override fun insertCamera(cameraModel: CameraModel) {
        dao.insertCamera(cameraModel.toDataDto())
    }

    override fun insertLocalCameras(cameraModels: List<CameraModel>) {
        dao.insertAllCameras(cameraModels.toDataDto())
    }

    override fun updateCamera(cameraModel: CameraModel) {
        dao.updateCamera(cameraModel.toDataDto())
    }

    override fun updateLocalCameras(cameraModels: List<CameraModel>) {
        dao.updateAllCameras(cameraModels.toDataDto())
    }

    override fun deleteCamera(cameraModel: CameraModel) {
        dao.deleteCamera(cameraModel.toDataDto())
    }
}