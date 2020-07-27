package com.example.ysc.cathayzoodemo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ysc.cathayzoodemo.repository.area.AreaListRepository

class HomeViewModelFactory(
    private val repository:AreaListRepository
):ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}