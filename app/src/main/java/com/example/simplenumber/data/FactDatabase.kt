package com.example.simplenumber.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FactEntity::class], version = 1)
abstract class FactDatabase : RoomDatabase () {
    abstract fun factDao(): FactDao

    companion object {
        private var INSTANCE: FactDatabase? = null
        fun getDatabase(context: Context): FactDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, FactDatabase::class.java, "fact_database")
                            .createFromAsset("assets/SimpleNumberFacts.db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}