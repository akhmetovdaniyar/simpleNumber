package com.example.simplenumber.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplenumber.domain.usecase.GetResultUsecase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }

}