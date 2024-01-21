package com.miu.gardeningjounal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notesapp.db.PlantsDatabase
import com.miu.gardeningjounal.databinding.FragmentGardenLogBinding
import com.miu.gardeningjounal.databinding.FragmentPlantDetailsBinding
import com.miu.gardeningjounal.databinding.PlantCardBinding
import com.miu.gardeningjounal.db.Plant
import kotlinx.coroutines.launch

class PlantDetails : BaseFragment() {

    private  lateinit var binding: FragmentPlantDetailsBinding
    private val nargs : PlantDetailsArgs by navArgs()
    private lateinit var viewModel: PlantsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantDetailsBinding.inflate(inflater,container, false)
        viewModel = ViewModelProvider(this).get(PlantsViewModel::class.java)

        val id = nargs.id;
        viewModel.getById(id).observeForever {
            if(it !== null){
                    binding.plantDetailsNameText.text = it.name
                    binding.plantDetailsPlantType.text = it.type
                    binding.plantDetailsWateringFrequency.text = it.wateringFrequency
                    binding.plantDetailsPlantedDate.text = it.plantedDate
            }
        }

        launch {
            context?.let {
                val plant = PlantsDatabase(it).getPlantsDao().getPlantById(id);

            }
        }
        return binding.root
    }

}