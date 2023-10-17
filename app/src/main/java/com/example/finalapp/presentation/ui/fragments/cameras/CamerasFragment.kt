package com.example.finalapp.presentation.ui.fragments.cameras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.finalapp.R
import com.example.finalapp.data.utils.Constants.NOT_FOUND
import com.example.finalapp.databinding.FragmentCamerasBinding
import com.example.finalapp.presentation.base.BaseFragment
import com.example.finalapp.presentation.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CamerasFragment :
    BaseFragment<FragmentCamerasBinding, CamerasViewModel>(R.layout.fragment_cameras) {

    override val viewModel: CamerasViewModel by viewModels()
    private val adapter = CamerasAdapter()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentCamerasBinding.inflate(inflater, container, false)

    override fun initView() {
        super.initView()
        binding.recyclerView.adapter = adapter
        viewModel.getAllCameras()
    }

    override fun initLiveData() {
        super.initLiveData()
        lifecycleScope.launch {
            viewModel.camerasList.collect { result ->
                when (result) {
                    is UiState.Loading -> binding.progressBar.visibility = View.VISIBLE

                    is UiState.Success -> {
                        adapter.setList(result.data!!)
                        binding.progressBar.visibility = View.GONE
                    }

                    is UiState.Empty -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), NOT_FOUND, Toast.LENGTH_SHORT).show()
                    }

                    is UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), result.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun initClick() {
        super.initClick()
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshCameras()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}