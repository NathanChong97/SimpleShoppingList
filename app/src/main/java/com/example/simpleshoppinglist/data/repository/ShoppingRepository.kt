package com.example.simpleshoppinglist.data.repository

import com.example.simpleshoppinglist.data.database.ShoppingDatabase
import com.example.simpleshoppinglist.data.database.entity.ShoppingItem

class ShoppingRepository (
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItem()
}