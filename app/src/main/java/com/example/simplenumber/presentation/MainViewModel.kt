package com.example.simplenumber.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplenumber.data.FactDao
import com.example.simplenumber.domain.usecase.GetResultUsecase
import kotlin.random.Random

class MainViewModel: ViewModel() {

    private var outLiveMutable = MutableLiveData<String>()
    var q: Int = 0
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

    fun getRandom() {
        q = Random.nextInt(7)
        factLiveMutable.value = factDao?.getFact(q)
    }





    private var factDao: FactDao? = null
    private var factLiveMutable = MutableLiveData<String>()
    val factLive: LiveData<String> = factLiveMutable

}