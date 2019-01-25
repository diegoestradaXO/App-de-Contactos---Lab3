package com.example.diego.appcontactos.Models

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import com.example.diego.appcontactos.R
import kotlinx.android.synthetic.main.activity_mail.*

class MailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)
        //Si apacha el boton de enviar
        sendButton.setOnClickListener {
            var recipient = recipient.text.toString().trim()//Obtiene el destinatario del Edit Text
            var subject = subject.text.toString().trim()//Obtiene el asunto
            var message = mensaje.text.toString().trim()//Obtiene el mensaje
            sendEmail(recipient, subject, message)//Usa la funcion de abajo
        }

    }
    private fun sendEmail(recipient: String, subject: String, message: String){
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(mIntent, "Choose email client..."))

        }
        catch (e: Exception){
            //Si no funciona
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}
