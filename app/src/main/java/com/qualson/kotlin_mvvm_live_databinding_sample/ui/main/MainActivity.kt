package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main

import android.os.Bundle
import com.qualson.kotlin_mvvm_live_databinding_sample.R
import com.qualson.kotlin_mvvm_live_databinding_sample.ui.common.BaseActivity
import com.qualson.kotlin_mvvm_live_databinding_sample.util.ActivityUtils

class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findOrCreateViewFragment()


    }

    private fun findOrCreateViewFragment(): MainFragment {
        val mainFragment: MainFragment = MainFragment.newInstance()
        ActivityUtils.replaceFragmentInActivity(supportFragmentManager, mainFragment,
                R.id.contentFrame)
        return mainFragment
    }
}
