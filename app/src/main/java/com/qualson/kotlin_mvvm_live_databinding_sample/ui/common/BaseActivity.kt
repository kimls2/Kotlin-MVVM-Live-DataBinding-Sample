package com.qualson.kotlin_mvvm_live_databinding_sample.ui.common

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.qualson.kotlin_mvvm_live_databinding_sample.BuildConfig
import com.qualson.kotlin_mvvm_live_databinding_sample.MyApp
import com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.component.ActivityComponent
import com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal.component.DaggerActivityComponent

/**
 * Created by ykim on 2017. 7. 3..
 */

abstract class BaseActivity : AppCompatActivity(), LifecycleRegistryOwner {

    protected var activityComponent: ActivityComponent? = null
    private val lifecycleRegistry = LifecycleRegistry(this)


    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        activityComponent = DaggerActivityComponent.builder().applicationComponent((applicationContext as MyApp).applicaionComponent).build()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (BuildConfig.DEBUG) {
            val refWatcher = MyApp.getRefWatcher(this)
            refWatcher.watch(this)
        }
    }


    protected abstract fun getLayoutResId(): Int
}
