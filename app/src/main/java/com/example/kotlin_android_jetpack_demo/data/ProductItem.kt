package com.example.kotlin_android_jetpack_demo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data  class ProductItem  (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "price") val price: Int?,
    @ColumnInfo(name = "seatCount") val seatCount: String?,
    @ColumnInfo(name = "engineSize") val engineSize: String?,
    @ColumnInfo(name = "yearOfManufacture") val yearOfManufacture: String?,
    @ColumnInfo(name = "establishedDate") val establishedDate: String?,
    @ColumnInfo(name = "lastModifyDate") val lastModifyDate: String?,
    @ColumnInfo(name = "modifyBy") val modifyBy: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "numOfDoor") val numOfDoor: String?,
    @ColumnInfo(name = "productStatus") val productStatus: String?,
    @ColumnInfo(name = "fuelType") val fuelType: String?,
    @ColumnInfo(name = "used") val used: String?,
    @ColumnInfo(name = "base64ImageTest") val base64ImageTest: String?,
    @ColumnInfo(name = "images") val images: Array<ProductImages>?,

    )

//{
//    "id": 54,
//    "name": "productVehicleTest",
//    "price": 50,
//    "brand": "root",
//    "seatCount": 4,
//    "engineSize": 5000,
//    "yearOfManufacture": "2021",
//    "establishedDate": 20210131,
//    "lastModifyDate": 20210131,
//    "modifyBy": "root",
//    "description": "2021-01-31",
//    "productStatus": "2021-01-31",
//    "numOfDoor": null,
//    "fuelType": null,
//    "used": null,
//    "images": [
//    {
//        "id": "1",
//        "filePath": "a.png",
//        "productId": "54"
//    },
//    {
//        "id": "2",
//        "filePath": "b.png",
//        "productId": "54"
//    },
//    {
//        "id": "4",
//        "filePath": "d.png",
//        "productId": "54"
//    }
//    ]
//}