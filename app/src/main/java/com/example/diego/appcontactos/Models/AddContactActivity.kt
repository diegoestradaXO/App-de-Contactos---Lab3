package com.example.diego.appcontactos.Models

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.diego.appcontactos.MainActivity
import com.example.diego.appcontactos.Models.MyApplication.Companion.contacts
import com.example.diego.appcontactos.R
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        back.setOnClickListener{
            val intent  = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        create.setOnClickListener {
            val name = name.text.toString()
            val number = number.text.toString()
            val email = email.text.toString()
            if (name!="" || number!=""|| email!=""){
                contacts.add(Contact(name,number,email))
                Toast.makeText(applicationContext,"Has agregado a $name a tus contactos...",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"No se pudo agregar contacto, llena todos los espacios...",Toast.LENGTH_SHORT).show()
            }
        }
    }

 }

