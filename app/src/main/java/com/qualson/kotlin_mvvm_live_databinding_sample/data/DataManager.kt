package com.qualson.kotlin_mvvm_live_databinding_sample.data

import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.GalleryImage
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.User
import com.qualson.kotlin_mvvm_live_databinding_sample.data.remote.ImgurService
import com.qualson.kotlin_mvvm_live_databinding_sample.data.local.SampleDb
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.internal.operators.completable.CompletableFromAction
import org.apache.commons.collections4.CollectionUtils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 7. 3..
 */
@Singleton class DataManager @Inject constructor(private val imgurService: ImgurService, private val sampleDb: SampleDb) {

    fun getGallery(): Observable<MutableList<GalleryImage>> {
        return imgurService.getGallery("hot", "viral")
                .filter({ (success, _, data) -> success && CollectionUtils.isNotEmpty(data) })
                .map { it.data }
    }

    fun insertUser(user: User): Completable {
        return CompletableFromAction(Action {
            sampleDb.beginTransaction()
            try {
                sampleDb.userDao().insert(user)
                sampleDb.setTransactionSuccessful()
            } finally {
                sampleDb.endTransaction()
            }
        })
    }

    fun selectUser(id: Int): Flowable<String> {
        return sampleDb.userDao().findNameById(id)
    }

}