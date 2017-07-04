package com.qualson.kotlin_mvp.di

import com.qualson.kotlin_mvp.data.remote.ImgurService
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
