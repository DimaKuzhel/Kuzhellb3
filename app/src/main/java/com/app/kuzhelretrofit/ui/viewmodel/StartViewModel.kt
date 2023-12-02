package com.app.kuzhelretrofit.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

enum class NavigationDestination {
    SHOW_TOUR
}

class FirstViewModel(app: Application) : AndroidViewModel(app) {
    private val _destination = MutableLiveData<NavigationDestination?>(null)
    val destination: LiveData<NavigationDestination?> get() = _destination
    fun start(){
                _destination.value = NavigationDestination.SHOW_TOUR
    }
}