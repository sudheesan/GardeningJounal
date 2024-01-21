package com.miu.gardeningjounal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notesapp.db.PlantsDatabase
import com.miu.gardeningjounal.db.Plant
import com.miu.gardeningjounal.db.PlantRepository
import kotlinx.coroutines.launch

class PlantsViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PlantRepository

    val allPlants : LiveData<List<Plant>>

    init {
        val plantDao = PlantsDatabase(application).getPlantsDao()
        repository = PlantRepository(application)
        allPlants = repository.allPlants
    }

    fun insert(plant:Plant) = viewModelScope.launch {
        repository.insert(plant)
    }

    fun getById(id:Int) : LiveData<Plant>{
        return repository.getPlantById(id)
    }

}