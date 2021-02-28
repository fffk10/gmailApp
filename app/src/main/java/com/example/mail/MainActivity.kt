package com.example.mail

import android.accounts.AbstractAccountAuthenticator
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText
import android.widget.Toast;
import java.nio.channels.AsynchronousByteChannel
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var toAddress: EditText
    private lateinit var content: EditText
    private lateinit var sendBtn: Button

    private lateinit var strToAddress: String
    private lateinit var strContent: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toAddress = findViewById(R.id.toAddress)
        content = findViewById(R.id.content)

        sendBtn = findViewById(R.id.button)

        // ボタン送信でメールを送信する
        sendBtn.setOnClickListener() {
            // ボタン送信で入力された宛先と本文を入力
            strToAddress = toAddress.text.toString()
            strContent = content.text.toString()

            // 送信情報
            val task = SendMail(
                    fromAddress = "warafffk10@gmail.com",
                    password = "emxfwiryektqdkea",
                    toAddress = strToAddress,
                    subject = "試し送り",
                    text = strContent
            )
            task.execute()
        }
    }
}