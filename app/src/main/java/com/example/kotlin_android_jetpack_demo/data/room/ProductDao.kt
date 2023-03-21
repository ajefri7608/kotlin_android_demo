package com.example.kotlin_android_jetpack_demo.data.room

import androidx.room.Dao
import androidx.room.Query
import com.example.kotlin_android_jetpack_demo.data.ProductItem


@Dao
 abstract class ProductDao : BaseDao<ProductItem> {
 @Query("SELECT * FROM productItem")
 abstract suspend fun getProductList(): ProductItem?
}