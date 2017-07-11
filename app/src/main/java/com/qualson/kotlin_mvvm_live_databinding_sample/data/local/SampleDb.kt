package com.qualson.kotlin_mvvm_live_databinding_sample.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.User

/**
 * Created by ykim on 2017. 7. 11..
 */
@Database(entities = arrayOf(User::class), version = 3)
abstract class SampleDb : RoomDatabase() {

    abstract fun userDao(): UserDao
}