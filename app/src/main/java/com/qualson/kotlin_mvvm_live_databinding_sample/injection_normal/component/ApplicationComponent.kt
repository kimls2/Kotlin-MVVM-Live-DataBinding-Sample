package com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.component

import android.app.Application
import android.content.Context
import com.qualson.kotlin_mvvm_live_databinding_sample.MyApp
import com.qualson.kotlin_mvvm_live_databinding_sample.data.DataManager
import com.qualson.kotlin_mvvm_live_databinding_sample.data.remote.ImgurService
import com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.ApplicationContext
import com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 4. 19..
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(myApp: MyApp)

    @ApplicationContext fun context(): Context

    fun application(): Application
    fun imgurService(): ImgurService
    fun dataManager(): DataManager
}