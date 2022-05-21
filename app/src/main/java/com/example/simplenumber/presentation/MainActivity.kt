package com.example.simplenumber.presentation

import android.os.Bundle
import android.text.InputType.TYPE_CLASS_NUMBER
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simplenumber.R
import com.example.simplenumber.domain.usecase.GetResultUsecase


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.textResult)
        val dataEditView = findViewById<EditText>(R.id.numberIn)
        dataEditView.inputType = TYPE_CLASS_NUMBER
        val sendButton = findViewById<Button>(R.id.buttonGet)
        sendButton.setOnClickListener {
            val oncheck = dataEditView.text.toString()
            if (oncheck.isEmpty()) {
                dataTextView.text = "Введите число"
            } else {
            val onnum = oncheck.toInt()
            val out = GetResultUsecase(onnum).calc()
            dataTextView.text = out }
        }
    }
}