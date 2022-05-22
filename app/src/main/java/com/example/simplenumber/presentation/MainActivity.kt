package com.example.simplenumber.presentation

import android.os.Bundle
import android.text.InputType.TYPE_CLASS_NUMBER
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplenumber.R
import com.example.simplenumber.domain.usecase.GetResultUsecase


class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this
            //MainViewModelFactory(this)
        ).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.textResult)
        val dataEditView = findViewById<EditText>(R.id.numberIn)
        dataEditView.inputType = TYPE_CLASS_NUMBER
        val sendButton = findViewById<Button>(R.id.buttonGet)

        vm.outLive.observe(this, Observer {
            dataTextView.text = it
        })

        sendButton.setOnClickListener {
            val oncheck = dataEditView.text.toString()
            vm.checkNumber(oncheck) }
    }
}