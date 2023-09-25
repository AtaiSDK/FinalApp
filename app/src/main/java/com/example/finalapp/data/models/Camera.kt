package com.example.finalapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camera")
data class Camera(
    @PrimaryKey
    val id: Long,
    val name: String = "Camera",
    val image: String? = null
)