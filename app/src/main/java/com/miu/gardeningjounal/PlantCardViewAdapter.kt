package com.miu.gardeningjounal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.miu.gardeningjounal.db.Plant

class PlantCardViewAdapter(var pList: ArrayList<Plant>): RecyclerView.Adapter<PlantCardViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlantCardViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.plant_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantCardViewAdapter.MyViewHolder, position: Int) {
        val constraintLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.plantCardLayout)
        constraintLayout.apply {
            val name = findViewById<TextView>(R.id.plantNameText)
            name.text = pList[position].name

            setOnClickListener{
                val directions = GardenLogDirections.actionGardenLogToPlantDetails(pList[position].id)
                findNavController().navigate(directions)
            }
        }
    }

    override fun getItemCount(): Int {
        return pList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
