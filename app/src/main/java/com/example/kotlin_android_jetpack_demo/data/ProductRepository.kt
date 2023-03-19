package com.example.kotlin_android_jetpack_demo.data

import android.util.Log
import com.example.kotlin_android_jetpack_demo.domain.ProductItem
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductList(): Flow<ResultsChange<ProductItem>>
    suspend fun addProduct(product: ProductItem)
    suspend fun deleteAllProduct()
    fun close()
}

class RealmProductRepository : ProductRepository {
    val config: RealmConfiguration
    val realm: Realm

    init {
        config = RealmConfiguration.create(schema = setOf(ProductItem::class))
        realm = Realm.open(config)
    }

    override fun getProductList(): Flow<ResultsChange<ProductItem>> {
        var items: RealmResults<ProductItem> = realm.query<ProductItem>().find()

        return items.asFlow()
    }

    override suspend fun addProduct(product: ProductItem) {
        realm.writeBlocking {
            copyToRealm(ProductItem().apply {

            })
        }
    }

    override suspend fun deleteAllProduct() {
        realm.writeBlocking {
            this.deleteAll()
        }
    }


    override fun close() {
        TODO("Not yet implemented")
    }
}