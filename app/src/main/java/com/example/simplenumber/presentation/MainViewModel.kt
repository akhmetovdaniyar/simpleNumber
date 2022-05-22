package com.example.simplenumber.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
}