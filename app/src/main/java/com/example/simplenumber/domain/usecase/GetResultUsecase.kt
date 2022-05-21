package com.example.simplenumber.domain.usecase

class GetResultUsecase(private val number: Int) {
    private var result : String = "Число простое"
    fun calc(): String {
            when (number) {
                0 -> result = "Число ноль"
                1 -> result = "Число единица"
                2 -> result = "Число простое и единственное четное"
                else -> for (i in 2 .. number / 2) {
                    val temp: Int = number % i
                    if (temp == 0) {
                        result = "Число составное"
                        break
                    }
                }
            }
        return result
    }
}