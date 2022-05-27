package com.example.simplenumber.data

import com.example.simplenumber.domain.repository.DatabaseHelper

class DatabaseHelperImpl(private val factDatabase: FactDatabase): DatabaseHelper {
    override fun getFact(n: Int): String = factDatabase.factDao().getFact(numberfact = n)

}