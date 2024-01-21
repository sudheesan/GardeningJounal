package com.miu.gardeningjounal.db

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.notesapp.db.PlantsDatabase

class PlantRepository(application: Application) {
    private val plantDao: PlantsDao
    val allPlants: LiveData<List<Plant>>

    init {
        val database = PlantsDatabase(application)
        plantDao = database.getPlantsDao()
        allPlants = plantDao.getAllPlants()
    }

    suspend fun insert(plant: Plant) {
        plantDao.addPlant(plant)
    }

    suspend fun update(plant: Plant) {
        plantDao.updatePlant(plant)
    }

    suspend fun delete(plant: Plant) {
        plantDao.deletePlant(plant)
    }

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantDao.getPlantById(plantId)
    }

}