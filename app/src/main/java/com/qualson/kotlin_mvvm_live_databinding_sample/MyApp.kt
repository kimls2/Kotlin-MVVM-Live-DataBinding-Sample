package com.qualson.kotlin_mvvm_live_databinding_sample

import android.app.Application
import android.content.Context
import com.qualson.kotlin_mvvm_live_databinding_sample.injection.AppComponent
import com.qualson.kotlin_mvvm_live_databinding_sample.injection.AppModule
import com.qualson.kotlin_mvvm_live_databinding_sample.injection.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import timber.log.Timber

/**
 * Created by ykim on 2017. 6. 28..
 */

class MyApp : Application() {

    private var refWatcher: RefWatcher? = null
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            refWatcher = LeakCanary.install(this)
        }
    }

    override fun getSystemService(name: String?): Any {
        when (name) {
            "component" -> return component
            else -> return super.getSystemService(name)
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
