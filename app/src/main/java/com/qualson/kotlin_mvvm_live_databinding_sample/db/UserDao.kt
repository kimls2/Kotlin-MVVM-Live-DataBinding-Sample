package com.qualson.kotlin_mvvm_live_databinding_sample.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.User

/**
 * Created by ykim on 2017. 7. 11..
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user WHERE login = :login")
    abstract fun findByLogin(login: String): LiveData<User>


}