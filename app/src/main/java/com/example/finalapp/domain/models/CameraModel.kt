package com.example.finalapp.domain.models

import androidx.room.PrimaryKey
import com.example.finalapp.data.models.Camera

data class CameraModel(
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val rec: Boolean,
    val room: String,
    val image: String
)