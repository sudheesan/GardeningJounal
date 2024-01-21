package com.miu.gardeningjounal.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Plant(
    val name: String,
    val type: String,
    val wateringFrequency: String,
    val plantedDate: String
    ):Serializable {

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}