package com.qualson.mvvm_live_databinding.data.model

import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.GalleryImage

/**
 * Created by ykim on 2017. 4. 11..
 */

data class GalleryResponse(val success: Boolean = false,
                           val status: Int = 0,
                           val data: MutableList<GalleryImage> = ArrayList())
