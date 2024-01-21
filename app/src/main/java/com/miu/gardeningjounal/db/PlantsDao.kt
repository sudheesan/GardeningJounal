package com.miu.gardeningjounal.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlantsDao {
    @Insert
    suspend fun addPlant(note:Plant)
    @Query("SELECT * FROM Plant ORDER BY id DESC")
    fun getAllPlants():LiveData<List<Plant>>
    @Query("SELECT * FROM Plant WHERE id = :id")
    fun getPlantById(id: Int): LiveData<Plant>
    @Insert
    suspend fun addMultiplePlants(vararg note: Plant)
    @Update
    suspend fun updatePlant(note:Plant)
    @Delete
    suspend fun deletePlant(note: Plant)
}