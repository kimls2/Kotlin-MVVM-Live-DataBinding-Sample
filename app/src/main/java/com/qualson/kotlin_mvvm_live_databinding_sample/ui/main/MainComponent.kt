package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main

import dagger.Subcomponent

/**
 * Created by ykim on 2017. 7. 11..
 */
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainFragment: MainFragment)
}