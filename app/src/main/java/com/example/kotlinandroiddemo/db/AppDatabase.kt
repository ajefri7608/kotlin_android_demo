package com.example.kotlinandroiddemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinandroiddemo.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}