package com.qualson.kotlin_mvp.data.model

/**
 * Created by ykim on 2017. 4. 11..
 */

data class GalleryResponse(val success: Boolean = false,
                           val status: Int = 0,
                           val data: MutableList<GalleryImage> = ArrayList())
