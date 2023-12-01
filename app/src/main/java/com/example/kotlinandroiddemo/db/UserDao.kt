package com.example.kotlinandroiddemo.db

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinandroiddemo.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE user_name = (:userName) AND password = (:password)")
    suspend fun getUserInfoByNameAndPw(userName: String, password: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserInfo(user: User)

}