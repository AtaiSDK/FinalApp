package com.example.finalapp.domain.models

import androidx.room.PrimaryKey
import com.example.finalapp.data.models.Camera

data class CameraModel (
    val id: Long,
    val name: String = "Camera",
    val image: String? = null
        )

fun Camera.mapToCameraModel(): CameraModel{
    return CameraModel(
        this.id,
        this.name,
        this.image
    )
}