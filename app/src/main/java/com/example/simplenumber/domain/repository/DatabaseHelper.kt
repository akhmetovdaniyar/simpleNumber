package com.example.simplenumber.domain.repository

interface DatabaseHelper {
    suspend fun getFact(): List<String>
}