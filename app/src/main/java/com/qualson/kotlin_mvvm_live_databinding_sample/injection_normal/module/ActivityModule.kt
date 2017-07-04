package com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.module

import android.app.Activity
import android.content.Context
import com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.ActivityContext
import dagger.Module
import dagger.Provides

/**
 * Created by ykim on 2017. 4. 19..
 */

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity = activity

    @Provides
    @ActivityContext
    internal fun provideContext(): Context = activity

}