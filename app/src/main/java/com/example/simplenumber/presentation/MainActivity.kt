package com.example.simplenumber.presentation

import android.os.Bundle
import android.text.InputType.TYPE_CLASS_NUMBER
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplenumber.R


class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this
            //MainViewModelFactory(this) - Создание при помощи "фабрики"
        ).get(MainViewModel::class.java)

        val resultTextView = findViewById<TextView>(R.id.textResult)
        val dataEditView = findViewById<EditText>(R.id.numberIn)
        dataEditView.inputType = TYPE_CLASS_NUMBER
        val sendButton = findViewById<Button>(R.id.buttonGet)
        val factTextView = findViewById<TextView>(R.id.textFact)



        vm.outLive.observe(this, Observer {
            resultTextView.text = it
        })

        sendButton.setOnClickListener {
            val oncheck = dataEditView.text.toString()
            vm.factLive.observe(this, Observer {
                factTextView.text = it
            })
            vm.checkNumber(oncheck) }
    }
}