package com.example.kotlin_android_jetpack_demo.data.room

import androidx.room.TypeConverter
import com.example.kotlin_android_jetpack_demo.data.ProductImages
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJsonString(value: List<ProductImages>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<ProductImages>::class.java).toList()
}