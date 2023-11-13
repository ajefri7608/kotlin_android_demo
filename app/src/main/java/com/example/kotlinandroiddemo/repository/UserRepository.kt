package com.example.kotlinandroiddemo.repository

import com.example.kotlinandroiddemo.db.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
}