package com.example.kotlin_android_jetpack_demo.domain

import ProductImages
import fakeImageBase64
import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class ProductItem() : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    var id:Int? = null
    var name: String = ""
    var price: Int? = null
    var seatCount: String = ""
    var engineSize: String = ""
    var yearOfManufacture: String = ""
    var establishedDate: String = ""
    var lastModifyDate: String = ""
    var modifyBy: String = ""
    var description: String = ""
    var productStatus: String? = ""
    var numOfDoor: String? = ""
    var fuelType: String? = ""
    var used: String? = ""
    var base64ImageTest:String? = fakeImageBase64
    var images: Array<ProductImages>? = arrayOf<ProductImages>()
}

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