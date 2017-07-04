package com.qualson.kotlin_mvp.injection_normal.component

import android.app.Application
import android.content.Context
import com.qualson.kotlin_mvp.MyApp
import com.qualson.kotlin_mvp.data.DataManager
import com.qualson.kotlin_mvp.data.remote.ImgurService
import com.qualson.kotlin_mvp.injection_normal.ApplicationContext
import com.qualson.kotlin_mvp.injection_normal.module.ApplicationModule
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