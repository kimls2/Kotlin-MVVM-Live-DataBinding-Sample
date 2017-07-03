package com.qualson.kotlin_mvvm_live_databinding_sample.di

import com.qualson.kotlin_mvvm_live_databinding_sample.data.remote.ImgurService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideImgurService(): ImgurService {
        return ImgurService.Factory.makeImugurService()
    }
}
