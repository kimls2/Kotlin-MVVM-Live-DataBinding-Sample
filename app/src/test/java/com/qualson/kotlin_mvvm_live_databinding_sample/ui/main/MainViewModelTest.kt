package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main

import com.qualson.kotlin_mvvm_live_databinding_sample.data.DataManager
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by ykim on 2017. 7. 11..
 */
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {


    @InjectMocks lateinit var mainViewModel: MainViewModel
    @Mock lateinit var dataManager: DataManager


    @Before
    fun setUp() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler({ Schedulers.trampoline() })
    }

    @After
    fun teaDown() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }

    @Test
    fun testNull() {
        Assert.assertThat(mainViewModel.select(), org.hamcrest.CoreMatchers.notNullValue())
    }

}