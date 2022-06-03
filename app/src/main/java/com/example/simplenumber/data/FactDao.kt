package com.example.simplenumber.data

import androidx.room.Dao
import androidx.room.Query
import kotlin.random.Random

@Dao
interface FactDao {
    @Query("SELECT Fact FROM main")
    suspend fun getFact(): List<String>
}