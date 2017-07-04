package com.qualson.kotlin_mvvm_live_databinding_sample.data

import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.GalleryImage
import com.qualson.kotlin_mvvm_live_databinding_sample.data.remote.ImgurService
import io.reactivex.Observable
import org.apache.commons.collections4.CollectionUtils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 7. 3..
 */
@Singleton class DataManager @Inject constructor(private val imgurService: ImgurService) {
    fun getGallery(): Observable<MutableList<GalleryImage>> {
        return imgurService.getGallery("hot", "viral")
                .filter({ (success, _, data) -> success && CollectionUtils.isNotEmpty(data) })
                .map { it.data }
    }

}