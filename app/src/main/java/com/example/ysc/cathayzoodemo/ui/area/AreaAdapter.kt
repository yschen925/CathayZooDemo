package com.example.ysc.cathayzoodemo.ui.area

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ysc.cathayzoodemo.data.PlantData
import com.example.ysc.cathayzoodemo.databinding.ListItemPlantRvBinding

class AreaAdapter(private val viewModel:AreaViewModel): RecyclerView.Adapter<AreaAdapter.ViewHolder>() {

    private var list: List<PlantData>? = viewModel.plants.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return AreaAdapter.ViewHolder(
            ListItemPlantRvBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list?.count() ?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list!![position]
        holder.bind(viewModel, item)
    }

    fun updateListData(viewModel:AreaViewModel){
        list = viewModel.plants.value
    }

    class ViewHolder constructor(
        private val binding: ListItemPlantRvBinding
    ):RecyclerView.ViewHolder(binding.root){
        init {
            binding.setClickListener {
                binding.plant?.let { item ->
                    navigateToPlant(binding.viewModel!!.area!!.name, item, it)
                }
            }
        }

        private fun navigateToPlant(
            areaName: String,
            item: PlantData,
            view: View
        ) {
            //check seq behavior
            val direction = AreaFragmentDirections.actionAreaFragmentToPlantFragment(
                areaName, item.name_ch
            )
            view.findNavController().navigate(direction)
        }


        fun bind(viewModel: AreaViewModel, plant:PlantData){
            binding.viewModel = viewModel
            binding.plant = plant
            binding.executePendingBindings()
        }
    }
}