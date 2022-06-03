package com.example.simplenumber.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FactEntity::class], version = 1)
abstract class FactDatabase : RoomDatabase () {
    abstract fun factDao(): FactDao

    object DatabaseBuilder {
        private var INSTANCE: FactDatabase? = null
        fun getDatabase(context: Context): FactDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, FactDatabase::class.java, "fact_database")
                    .createFromAsset("Facts.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance

            }
        }
    }
}