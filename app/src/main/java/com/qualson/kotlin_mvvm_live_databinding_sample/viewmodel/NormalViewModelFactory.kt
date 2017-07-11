package com.qualson.kotlin_mvvm_live_databinding_sample.viewmodel

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.qualson.kotlin_mvvm_live_databinding_sample.data.DataManager
import com.qualson.kotlin_mvvm_live_databinding_sample.ui.main.MainViewModel
import javax.inject.Inject
import javax.inject.Singleton


@Suppress("UNCHECKED_CAST")
/**
 * Factory for ViewModels
 */
@Singleton
class NormalViewModelFactory @Inject constructor(val application: Application, val dataManager: DataManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application, dataManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
