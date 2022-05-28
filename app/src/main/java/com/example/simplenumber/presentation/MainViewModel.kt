package com.example.simplenumber.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplenumber.data.FactDao
import com.example.simplenumber.domain.usecase.GetResultUsecase

class MainViewModel: ViewModel() {

    private var outLiveMutable = MutableLiveData<String>()
    val outLive: LiveData<String> = outLiveMutable

    fun checkNumber(num: String) {
        if (num.isEmpty()) {
            outLiveMutable.value = "Введите число"
        } else {
            val onnum = num.toInt()
            val out = GetResultUsecase(onnum).calc()
            outLiveMutable.value = out
        }
    }

    private var factDao: FactDao? = null
    private var factLiveMutable = MutableLiveData<String>()
    val factLive: LiveData<String> = factLiveMutable
    suspend fun getFact(q: Int) {
        factLiveMutable.value = factDao?.getFact(q)
    }
}