package com.qualson.kotlin_mvvm_live_databinding_sample.data

import com.qualson.kotlin_mvvm_live_databinding_sample.data.remote.ImgurService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 7. 3..
 */
@Singleton class DataManager @Inject constructor(private val imgurService: ImgurService)