package com.example.kotlinandroiddemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinandroiddemo.db.AppDatabase
import com.example.kotlinandroiddemo.db.UserDao
import com.example.kotlinandroiddemo.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val db: AppDatabase) {
    val userInfo = MutableLiveData<User>()


    suspend fun getUser(userName: String, password: String) {
        var response = db.userDao().getUserInfoByNameAndPw(userName, password)
        if (response !== null) {
            userInfo.postValue(response)
        }


    }

    suspend fun setUser(user: User) {
        db.userDao().saveUserInfo(user)
    }
}