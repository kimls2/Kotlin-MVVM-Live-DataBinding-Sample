package com.qualson.kotlin_mvvm_live_databinding_sample.injection

import android.app.Application
import com.qualson.kotlin_mvvm_live_databinding_sample.data.remote.ImgurService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 7. 11..
 */
@Module
class AppModule(private val application: Application) {

    @Provides fun application(): Application {
        return application
    }

    @Singleton
    @Provides
    fun provideImgurService(): ImgurService {
        return ImgurService.Factory.makeImugurService()
    }
}