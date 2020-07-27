package com.example.ysc.cathayzoodemo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ysc.cathayzoodemo.data.AreaData
import com.example.ysc.cathayzoodemo.databinding.ListItemHomeRvBinding

class HomeAdapter(private val viewModel: HomeViewModel):RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var list: List<AreaData>? = viewModel.areaListLiveData.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        return ViewHolder(ListItemHomeRvBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }


    override fun getItemCount(): Int {
        return list?.count() ?:0
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val item = list!![position]
        holder.bind(viewModel, item)
    }

    class ViewHolder constructor(
        private val binding:ListItemHomeRvBinding
    ): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.item?.let { item ->
                    navigateToArea(item, it)
                }
            }
        }

        private fun navigateToArea(
            item: AreaData,
            view: View
        ) {
            val direction = HomeFragmentDirections.actionNavHomeToAreaFragment(
                    item.id, item.name
                )
            view.findNavController().navigate(direction)
        }


        fun bind(viewModel: HomeViewModel, item:AreaData){
            binding.viewModel = viewModel
            binding.item = item
            binding.executePendingBindings()
        }

    }
}