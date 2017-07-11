package com.qualson.kotlin_mvvm_live_databinding_sample.injection

import com.qualson.kotlin_mvvm_live_databinding_sample.ui.main.MainComponent
import com.qualson.kotlin_mvvm_live_databinding_sample.ui.main.MainModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 7. 11..
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(mainModule: MainModule): MainComponent
}