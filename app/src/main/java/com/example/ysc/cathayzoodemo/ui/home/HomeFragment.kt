package com.example.ysc.cathayzoodemo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ysc.cathayzoodemo.R
import com.example.ysc.cathayzoodemo.data.AreaData
import com.example.ysc.cathayzoodemo.repository.area.AreaListRepository

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(AreaListRepository(resources))
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val homeRecyclerView: RecyclerView = root.findViewById(R.id.home_rv)
        val adapter = HomeAdapter(homeViewModel)
        homeRecyclerView.adapter = adapter
        homeViewModel.areaListLiveData.observe(viewLifecycleOwner,
        Observer {
            adapter.notifyDataSetChanged()
        })

        return root
    }
}