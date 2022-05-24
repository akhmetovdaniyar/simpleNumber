package com.example.simplenumber.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "main")
data class FactEntity (
    @PrimaryKey(autoGenerate = true) val N: Int,
    @ColumnInfo(name = "Fact") val Fact: String
)