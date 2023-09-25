package com.example.finalapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "door")
data class Door(
    @PrimaryKey
    val id: Long,
    val name: String = "door",
    val image: String? = null
)