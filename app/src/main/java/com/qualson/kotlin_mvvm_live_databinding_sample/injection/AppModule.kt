package com.qualson.kotlin_mvvm_live_databinding_sample.injection

import android.app.Application
import android.arch.persistence.room.Room
import com.qualson.kotlin_mvvm_live_databinding_sample.data.remote.ImgurService
import com.qualson.kotlin_mvvm_live_databinding_sample.db.SampleDb
import com.qualson.kotlin_mvvm_live_databinding_sample.db.UserDao
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

    @Singleton
    @Provides
    fun provideSampleDb(application: Application): SampleDb {
        return Room.databaseBuilder(application, SampleDb::class.java, "sample.db").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(sampleDb: SampleDb): UserDao {
        return sampleDb.userDao()
    }
}