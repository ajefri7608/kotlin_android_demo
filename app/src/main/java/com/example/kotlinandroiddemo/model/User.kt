package com.example.kotlinandroiddemo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: String,
    @ColumnInfo(name = "user_name")
    val userName: String,
    @ColumnInfo(name = "password")
    val password: String?,
    val jwtToken: String,

    )