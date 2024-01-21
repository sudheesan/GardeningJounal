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
import com.miu.gardeningjounal.databinding.FragmentAddNewPlantBinding
import com.miu.gardeningjounal.databinding.FragmentGardenLogBinding
import com.miu.gardeningjounal.db.Plant
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddNewPlant.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddNewPlant : BaseFragment() {
    private lateinit var viewModel: PlantsViewModel
    private lateinit var binding: FragmentAddNewPlantBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNewPlantBinding.inflate(inflater, container, false)

        binding.buttonAddNewPlant.setOnClickListener {
            val name = binding.addPlantName.text.toString()
            val type = binding.addPlantType.text.toString()
            val wf = binding.addPlantWateringFrequncy.text.toString()
            val pd = binding.addPlantPlantedDate.text.toString()

            viewModel = ViewModelProvider(this).get(PlantsViewModel::class.java)

            if (name.isNotEmpty() && type.isNotEmpty() && wf.isNotEmpty() && pd.isNotEmpty()) {

                viewModel.insert( Plant(
                    name, type, wf, pd
                ))

                context?.toast("Plant Added")
                val direction = AddNewPlantDirections.actionAddNewPlantToGardenLog()
                findNavController().navigate(direction)
            } else {
                context?.toast("Please fill the fields")
            }
        }

        return binding.root
    }

}