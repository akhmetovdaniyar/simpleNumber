package com.example.simplenumber.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface FactDao {

    @Query("SELECT Fact FROM main WHERE N = :numberfact")
    fun getFact(numberfact: Int): String

}