package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.qualson.kotlin_mvvm_live_databinding_sample.data.DataManager
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ykim on 2017. 7. 11..
 */
@RunWith(JUnit4::class)
class MainViewModelTest {

    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private var mainViewModel: MainViewModel? = null
    private val dataManager: DataManager? = null


    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

}