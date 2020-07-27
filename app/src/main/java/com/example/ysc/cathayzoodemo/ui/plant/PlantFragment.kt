package com.example.ysc.cathayzoodemo.ui.plant

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.ysc.cathayzoodemo.R
import com.example.ysc.cathayzoodemo.databinding.FragmentAreaBinding
import com.example.ysc.cathayzoodemo.databinding.FragmentPlantBinding
import com.example.ysc.cathayzoodemo.repository.area.AreaListRepository
import com.example.ysc.cathayzoodemo.repository.plant.PlantListRepository
import com.example.ysc.cathayzoodemo.ui.area.AreaFragmentArgs
import com.example.ysc.cathayzoodemo.ui.area.AreaViewModel
import com.example.ysc.cathayzoodemo.ui.area.AreaViewModelFactory

class PlantFragment : Fragment() {

    companion object {
        fun newInstance() =
            PlantFragment()
    }

    private val args: PlantFragmentArgs by navArgs()
    private val plantViewModel: PlantViewModel by viewModels {
        PlantViewModelFactory(PlantListRepository(), args.areaName, args.plantNameCh)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPlantBinding>(
            inflater, R.layout.fragment_plant, container, false
        ).apply{
            viewModel = plantViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}