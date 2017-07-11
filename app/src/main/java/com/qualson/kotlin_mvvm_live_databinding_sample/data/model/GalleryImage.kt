package com.qualson.kotlin_mvvm_live_databinding_sample.data.model


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
) {
    fun getUrl(): String {
        var thumbnailId = id
        if (is_album) {
            thumbnailId = cover
        }
        return BASE_IMAGE_ADDRESS + thumbnailId + MEDIUM_THUMBNAIL + ".jpg"
    }

    companion object {
        private val BASE_IMAGE_ADDRESS = "http://i.imgur.com/"
        val MEDIUM_THUMBNAIL = 'm'

        fun getThumbnailSize(id: String?, is_album: Boolean, cover: String?): String {
            var thumbnailId = id
            if (is_album) {
                thumbnailId = cover
            }
            return BASE_IMAGE_ADDRESS + thumbnailId + MEDIUM_THUMBNAIL + ".jpg"
        }
    }
}
