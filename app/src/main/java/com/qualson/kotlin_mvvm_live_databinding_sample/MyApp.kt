package com.qualson.mvvm_live_databinding

import android.app.Activity
import android.app.Application
import android.content.Context
import com.qualson.kotlin_mvvm_live_databinding_sample.BuildConfig
import com.qualson.kotlin_mvvm_live_databinding_sample.di.AppInjector
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ykim on 2017. 6. 28..
 */

class MyApp @Inject constructor(private val dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>) : Application(), HasActivityInjector {

    private var refWatcher: RefWatcher? = null

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            refWatcher = LeakCanary.install(this)
        }

        AppInjector.init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector!!
    }

    companion object {
        fun getRefWatcher(context: Context): RefWatcher {
            val application = context.applicationContext as MyApp
            return application.refWatcher!!
        }
    }
}
