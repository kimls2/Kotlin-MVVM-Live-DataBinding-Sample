package com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.component

import com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.PerActivity
import com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.module.ActivityModule
import com.qualson.kotlin_mvvm_live_databinding_sample.ui.main.MainActivity
import dagger.Component

/**
 * Created by ykim on 2017. 4. 19..
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}