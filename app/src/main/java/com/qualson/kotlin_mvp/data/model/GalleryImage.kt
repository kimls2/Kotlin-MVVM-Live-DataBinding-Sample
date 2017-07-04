package com.qualson.kotlin_mvp.data.model


/**
 * Created by ykim on 2017. 4. 11..
 */

data class GalleryImage(
        val id: String,
        var title: String,
        var description: String,
        val type: String,
        val width: Int,
        val height: Int,
        val size: Int,
        val section: String,
        val ups: Int,
        val downs: Int,
        val score: Int,
        var link: String,
        val cover: String,
        val gifv: String,
        val animated: Boolean,
        val cover_width: Int,
        val is_album: Boolean,
        val cover_height: Int,
        val aspectRation: Float
)
