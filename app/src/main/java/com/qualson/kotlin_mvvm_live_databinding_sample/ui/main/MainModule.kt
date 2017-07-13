package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main

import com.qualson.kotlin_mvvm_live_databinding_sample.data.DataManager
import dagger.Module
import dagger.Provides

/**
 * Created by ykim on 2017. 7. 11..
 */
@Module
class MainModule {

    @Provides
    fun provideMainViewModel(dataManager: DataManager): MainViewModel {
        return MainViewModel(dataManager)
    }
}