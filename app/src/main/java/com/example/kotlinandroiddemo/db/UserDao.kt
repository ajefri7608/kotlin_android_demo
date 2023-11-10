package com.example.kotlinandroiddemo.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinandroiddemo.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE userId IN (:userId)")
    fun loadAllByIds(userId: Int): List<User>

}