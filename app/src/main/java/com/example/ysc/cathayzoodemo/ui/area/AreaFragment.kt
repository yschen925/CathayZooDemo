package com.example.ysc.cathayzoodemo.ui.area

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.ysc.cathayzoodemo.R
import com.example.ysc.cathayzoodemo.api.PlantApi
import com.example.ysc.cathayzoodemo.data.AreaData
import com.example.ysc.cathayzoodemo.data.PlantData
import com.example.ysc.cathayzoodemo.databinding.FragmentAreaBinding
import com.example.ysc.cathayzoodemo.repository.area.AreaListRepository
import com.example.ysc.cathayzoodemo.repository.plant.PlantListRepository
import com.example.ysc.cathayzoodemo.ui.home.HomeAdapter

class AreaFragment : Fragment() {

    companion object {
        fun newInstance() = AreaFragment()
    }

    private val args: AreaFragmentArgs by navArgs()
    private val areaViewModel: AreaViewModel by viewModels {
        AreaViewModelFactory(AreaListRepository(resources), args.id, PlantListRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentAreaBinding>(
            inflater, R.layout.fragment_area, container, false
        ).apply{
            viewModel = areaViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        //url
        val urlBtn: TextView = binding.root.findViewById(R.id.area_url_btn)
        urlBtn.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(areaViewModel.area.url)
            startActivity(openURL)
        }

        //plant
        val areaRecyclerView: RecyclerView = binding.root.findViewById(R.id.area_rv)
        val adapter = AreaAdapter(areaViewModel)
        areaRecyclerView.adapter = adapter
        areaViewModel.plants.observe(viewLifecycleOwner,
            Observer{
                adapter.updateListData(areaViewModel)//check sol
                adapter.notifyDataSetChanged()
            })

        return binding.root
    }
}