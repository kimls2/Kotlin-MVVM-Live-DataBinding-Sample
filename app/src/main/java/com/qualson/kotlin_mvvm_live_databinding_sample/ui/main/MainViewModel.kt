package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main


import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.qualson.kotlin_mvvm_live_databinding_sample.data.DataManager
import com.qualson.kotlin_mvvm_live_databinding_sample.data.SingleLiveEvent
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.GalleryImage
import com.qualson.kotlin_mvvm_live_databinding_sample.util.SnackbarMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
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

    fun loadImages() {
        compositeDisposable.add(dataManager.getGallery()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<GalleryImage>>() {
                    override fun onNext(@NonNull galleryImages: List<GalleryImage>) {
                        mGalleryImages.value = galleryImages
                        snackbarMessage.value = "success"
                    }

                    override fun onError(@NonNull e: Throwable) {
                        Timber.e(e.message)
                        snackbarMessage.value = e.localizedMessage
                    }

                    override fun onComplete() {
                        Timber.e("complete")
                        snackbarMessage.value = "completed"
                    }
                }))
    }

    fun destroy() {
        compositeDisposable.clear()
        Timber.e("destroy")
    }

    fun getListGalleryImages(): SingleLiveEvent<List<GalleryImage>> {
        return mGalleryImages
    }
}
