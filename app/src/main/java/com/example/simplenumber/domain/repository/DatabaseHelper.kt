package com.example.simplenumber.domain.repository

interface DatabaseHelper {
    fun getFact(n: Int): String
}