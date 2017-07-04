package com.qualson.kotlin_mvp.ui.main

import android.os.Bundle
import com.qualson.kotlin_mvp.R
import com.qualson.kotlin_mvp.ui.common.BaseActivity
import com.qualson.kotlin_mvp.util.ActivityUtils

class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent!!.inject(this)
        findOrCreateViewFragment()
    }

    private fun findOrCreateViewFragment(): MainFragment {
        val mainFragment: MainFragment = MainFragment.newInstance()
        ActivityUtils.replaceFragmentInActivity(supportFragmentManager, mainFragment,
                R.id.contentFrame)

        return mainFragment
    }
}
