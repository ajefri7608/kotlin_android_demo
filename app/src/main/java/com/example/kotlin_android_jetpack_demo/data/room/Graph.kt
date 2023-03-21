package com.example.kotlin_android_jetpack_demo.data.room

import android.content.Context
import androidx.room.Room
import java.io.File

object  Graph {
    lateinit var database: AppDatabase

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, AppDatabase::class.java, "data.db")
            // This is not recommended for normal apps, but the goal of this sample isn't to
            // showcase all of Room.
            .fallbackToDestructiveMigration()
            .build()
    }
}