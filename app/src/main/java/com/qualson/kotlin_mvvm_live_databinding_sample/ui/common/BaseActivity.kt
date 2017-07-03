package com.qualson.mvvm_live_databinding.ui.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.qualson.mvvm_live_databinding.MyApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by ykim on 2017. 7. 3..
 */

abstract class BaseActivity : AppCompatActivity(), LifecycleRegistryOwner, HasSupportFragmentInjector {


    //    @Inject constructor(private val dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>)
    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
    }

    override fun onDestroy() {
        super.onDestroy()
        val refWatcher = MyApp.getRefWatcher(this)
        refWatcher.watch(this)
    }


    protected abstract fun getLayoutResId(): Int
}
