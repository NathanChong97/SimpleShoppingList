package com.example.simpleshoppinglist.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simpleshoppinglist.data.database.entity.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        //Make sure there is only one instance of the database object
        @Volatile   //volatile is used to make it's rights visible to all threads
        private var instance: ShoppingDatabase? = null

        private val LOCK = Any()

        //this function will execute whenever ShoppingDatabase() is used
        //synchronized is used to make sure no other threads are using the instance at the same time
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: createDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}