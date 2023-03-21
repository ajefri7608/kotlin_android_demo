package com.example.kotlin_android_jetpack_demo.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin_android_jetpack_demo.data.ProductItem

@Database(entities = [ProductItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ProductDao
}