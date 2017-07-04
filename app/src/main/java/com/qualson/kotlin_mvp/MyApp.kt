package com.qualson.kotlin_mvp

import android.app.Application
import android.content.Context
import com.qualson.kotlin_mvp.injection_normal.component.ApplicationComponent
import com.qualson.kotlin_mvp.injection_normal.component.DaggerApplicationComponent
import com.qualson.kotlin_mvp.injection_normal.module.ApplicationModule
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import timber.log.Timber

/**
 * Created by ykim on 2017. 6. 28..
 */

class MyApp : Application() {

    lateinit var applicaionComponent: ApplicationComponent
    private var refWatcher: RefWatcher? = null

    override fun onCreate() {
        super.onCreate()
        applicaionComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            refWatcher = LeakCanary.install(this)
        }
    }

    companion object {
        @JvmStatic fun getRefWatcher(context: Context): RefWatcher {
            val application = context.applicationContext as MyApp
            return application.refWatcher!!
        }

        @JvmStatic fun get(context: Context): MyApp {
            return context.applicationContext as MyApp
        }
    }
}
