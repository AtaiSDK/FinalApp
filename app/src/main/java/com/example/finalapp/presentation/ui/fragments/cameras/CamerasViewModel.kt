package com.example.finalapp.presentation.ui.fragments.cameras

import androidx.lifecycle.viewModelScope
import com.example.finalapp.domain.models.CameraModel
import com.example.finalapp.domain.usecases.cameras.*
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
class CamerasViewModel @Inject constructor(
    private val getAllCamerasUseCase: GetAllCamerasUseCase,
    private val refreshCamerasUseCase: RefreshCamerasUseCase,
    private val insertCameraUseCase: InsertCameraUseCase,
    private val updateCameraUseCase: UpdateCameraUseCase,
    private val deleteCameraUseCase: DeleteCameraUseCase
) : BaseViewModel() {

    private val _camerasList = MutableStateFlow<UiState<List<CameraModel>>>(UiState.Loading())
    val camerasList: StateFlow<UiState<List<CameraModel>>> = _camerasList

    fun getAllCameras() = doRequest {
        getAllCamerasUseCase()
    }

    fun refreshCameras() = doRequest {
        refreshCamerasUseCase()
    }

    private fun doRequest(useCase: suspend () -> Flow<Resource<List<CameraModel>>>) {
        viewModelScope.launch(Dispatchers.IO) {
            _camerasList.value = collectData { useCase() }
        }
    }
}