package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main

import android.os.Bundle
import com.qualson.kotlin_mvvm_live_databinding_sample.R
import com.qualson.kotlin_mvvm_live_databinding_sample.util.ActivityUtils
import com.qualson.mvvm_live_databinding.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        findOrCreateViewFragment()
    }

    private fun findOrCreateViewFragment(): MainFragment {
        var mainFragment: MainFragment? = supportFragmentManager.findFragmentById(R.id.contentFrame) as MainFragment
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance()
            ActivityUtils.replaceFragmentInActivity(supportFragmentManager, mainFragment,
                    R.id.contentFrame)
        }
        return mainFragment
    }
}
