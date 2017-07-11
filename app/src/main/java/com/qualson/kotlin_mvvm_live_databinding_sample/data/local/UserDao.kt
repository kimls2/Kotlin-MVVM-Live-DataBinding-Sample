package com.qualson.kotlin_mvvm_live_databinding_sample.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.User
import io.reactivex.Flowable

/**
 * Created by ykim on 2017. 7. 11..
 */
@Dao
interface
UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT name FROM user WHERE id = :id")
    fun findNameById(id: Int): Flowable<String>

}