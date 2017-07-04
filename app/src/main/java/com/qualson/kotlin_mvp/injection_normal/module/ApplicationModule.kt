package com.qualson.kotlin_mvp.injection_normal.module

import android.app.Application
import android.content.Context
import com.qualson.kotlin_mvp.data.remote.ImgurService
import com.qualson.kotlin_mvp.injection_normal.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ykim on 2017. 4. 19..
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    internal fun provideApplication(): Application = application

    @Provides
    @ApplicationContext
    internal fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    internal fun provideImgurService(): ImgurService {
        return ImgurService.Factory.makeImugurService()
    }
}