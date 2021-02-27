package com.example.mail

import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import android.os.AsyncTask
import java.util.*
import javax.mail.*

@Suppress("DEPRECATION")
class SendMail(
        private val fromAddress: String,
        private val password: String,
        private val toAddress: String,
        private val subject: String,
        private val text: String
) : AsyncTask<Unit, Unit, Unit>() {

    override fun doInBackground(vararg params: Unit?) {
        val props = Properties().apply {
            putAll(mapOf(
                    "mail.smtp.host" to "smtp.gmail.com",
                    "mail.smtp.socketFactory.port" to "465",
                    "mail.smtp.socketFactory.class" to "javax.net.ssl.SSLSocketFactory",
                    "mail.smtp.auth" to "true",
                    "mail.smtp.port" to "465"
            ))
        }

        val session = Session.getDefaultInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication() = PasswordAuthentication(fromAddress, password)
        })

        val message = MimeMessage(session).also {
            it.setFrom(InternetAddress(fromAddress))
            it.addRecipient(Message.RecipientType.TO, InternetAddress(toAddress))
            it.subject = subject
            it.setText(text)
        }

        Transport.send(message)
    }

}
