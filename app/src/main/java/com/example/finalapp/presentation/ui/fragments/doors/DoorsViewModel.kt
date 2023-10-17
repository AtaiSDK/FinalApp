package com.example.finalapp.presentation.ui.fragments.doors

import androidx.lifecycle.viewModelScope
import com.example.finalapp.domain.models.DoorModel
import com.example.finalapp.domain.usecases.doors.*
import com.example.finalapp.domain.utils.Resource
import com.example.finalapp.presentation.base.BaseViewModel
import com.example.finalapp.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getAllDoorsUseCase: GetAllDoorsUseCase,
    private val refreshDoorsUseCase: RefreshDoorsUseCase,
    private val insertDoorUseCase: InsertDoorUseCase,
    private val updateDoorUseCase: UpdateDoorUseCase,
    private val deleteDoorUseCase: DeleteDoorUseCase
) : BaseViewModel() {

    private val _doorsList = MutableStateFlow<UiState<List<DoorModel>>>(UiState.Loading())
    val doorsList: StateFlow<UiState<List<DoorModel>>> = _doorsList

    fun getAllDoors() = doRequest {
        getAllDoorsUseCase()
    }

    fun refreshDoors() = doRequest {
        refreshDoorsUseCase()
    }

    private fun doRequest(useCase: suspend () -> Flow<Resource<List<DoorModel>>>) {
        viewModelScope.launch(Dispatchers.IO) {
            _doorsList.value = collectData { useCase() }
        }
    }
}