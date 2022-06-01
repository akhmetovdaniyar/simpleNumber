package com.example.simplenumber.data

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var INSTANCE: FactDatabase? = null
    fun getDatabase(context: Context): FactDatabase {
        if (INSTANCE == null) {
            synchronized(this) {
                INSTANCE =
                    Room.databaseBuilder(context, FactDatabase::class.java, "fact_database")
                        .createFromAsset("Facts.db")
                        .build()
            }
        }
        return INSTANCE!!
    }

}