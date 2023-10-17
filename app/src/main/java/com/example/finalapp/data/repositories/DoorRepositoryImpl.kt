package com.example.finalapp.data.repositories

import com.example.finalapp.data.db.DoorDao
import com.example.finalapp.data.dtos.toDataDto
import com.example.finalapp.data.dtos.toDomainModel
import com.example.finalapp.data.remote.HouseApiService
import com.example.finalapp.data.utils.GetResource
import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.repositories.DoorRepository
import com.example.finalapp.data.dtos.toDataDto
import javax.inject.Inject

class DoorRepositoryImpl @Inject constructor(
    private val dao: DoorDao,
    private val houseApiService: HouseApiService,
) : DoorRepository, GetResource() {
    override suspend fun getRemoteDoors() = getResult {
        houseApiService.getDoor().body()!!.data.toDomainModel()
    }

    override fun getLocalDoors(): List<DoorModel> {
        return dao.getAllDoors().toDomainModel()
    }

    override fun insertDoor(doorModel: DoorModel) {
        dao.insertDoor(doorModel.toDataDto())
    }


    override fun insertLocalDoors(doorModels: List<DoorModel>) {
        dao.insertAllDoors(doorModels.toDataDto())
    }

    override fun updateDoor(doorModel: DoorModel) {
        dao.updateDoor(doorModel.toDataDto())
    }

    override fun updateLocalDoors(doorModels: List<DoorModel>) {
        dao.updateAllDoors(doorModels.toDataDto())
    }

    override fun deleteDoor(doorModel: DoorModel) {
        dao.deleteDoor(doorModel.toDataDto())
    }
}