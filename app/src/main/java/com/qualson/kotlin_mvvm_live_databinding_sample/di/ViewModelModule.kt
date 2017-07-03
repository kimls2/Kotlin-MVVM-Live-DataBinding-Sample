package com.qualson.kotlin_mvvm_live_databinding_sample.di


import android.arch.lifecycle.ViewModelProvider
import com.qualson.kotlin_mvvm_live_databinding_sample.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel::class)
//    internal abstract fun bindMainViewModel(userViewModel: MainViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
