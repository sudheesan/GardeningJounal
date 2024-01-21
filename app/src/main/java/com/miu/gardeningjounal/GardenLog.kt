package com.miu.gardeningjounal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.db.PlantsDatabase
import com.miu.gardeningjounal.databinding.FragmentGardenLogBinding
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [GardenLog.newInstance] factory method to
 * create an instance of this fragment.
 */
class GardenLog : BaseFragment() {
    private lateinit var viewModel: PlantsViewModel

    private  lateinit var binding: FragmentGardenLogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGardenLogBinding.inflate(inflater,container, false)

        viewModel = ViewModelProvider(this).get(PlantsViewModel::class.java)

        viewModel.allPlants.observeForever {
            binding.rvPlants.adapter = PlantCardViewAdapter(ArrayList(it))
            binding.rvPlants.layoutManager = LinearLayoutManager(requireContext())
        }

        binding.addPlant.setOnClickListener {
            var direction = GardenLogDirections.actionGardenLogToAddNewPlant()
            findNavController().navigate(direction)
        }

        return binding.root
    }

}