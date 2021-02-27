package com.example.mail

import android.accounts.AbstractAccountAuthenticator
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.nio.channels.AsynchronousByteChannel
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = SendMail(
                fromAddress = "warafffk10@gmail.com",
                password = "emxfwiryektqdkea",
                toAddress = "02hrmr02@gmail.com",
                subject = "試し送り",
                text = "わらさんだよ"
        )
        task.execute()
    }
}