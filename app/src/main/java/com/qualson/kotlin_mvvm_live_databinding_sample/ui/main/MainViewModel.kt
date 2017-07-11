package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main


import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.qualson.kotlin_mvvm_live_databinding_sample.data.DataManager
import com.qualson.kotlin_mvvm_live_databinding_sample.data.SingleLiveEvent
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.GalleryImage
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.User
import com.qualson.kotlin_mvvm_live_databinding_sample.util.SnackbarMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


class MainViewModel @Inject
constructor(context: Application, val dataManager: DataManager) : AndroidViewModel(context) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val mGalleryImages: SingleLiveEvent<List<GalleryImage>> = SingleLiveEvent()
    val snackbarMessage = SnackbarMessage()

    fun start() {
        loadImages()
    }

    fun select() {
        val id = 1
        compositeDisposable.add(dataManager.selectUser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { println(" name : $it") }, onError = { println("error :" + it.localizedMessage) }

                )

        )
    }

    fun insert() {
        val user = User(1, "test")
        compositeDisposable.add(dataManager.insertUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = {
                            snackbarMessage.value = it.localizedMessage
                            println("insert fail")
                        },
                        onComplete = {
                            snackbarMessage.value = "insert success!!!"
                            println("insert success")
                        }
                )

        )
    }

    fun loadImages() {
        compositeDisposable.add(dataManager.getGallery()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext = { mGalleryImages.value = it },
                        onError = {
                            snackbarMessage.value = it.localizedMessage
                        },
                        onComplete = {
                            snackbarMessage.value = "completed"
                        }
                ))

    }

    fun destroy() {
        compositeDisposable.clear()
        Timber.e("destroy")
    }

    fun getListGalleryImages(): SingleLiveEvent<List<GalleryImage>> {
        return mGalleryImages
    }
}
