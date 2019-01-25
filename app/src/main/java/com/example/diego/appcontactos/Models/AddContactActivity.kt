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
        //Boton para regresar al menu
        back.setOnClickListener{
            val intent  = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //Boton para agregarcontacto
        create.setOnClickListener {
            val name = name.text.toString()//Toma el texto del Edit Text y los pasa a la variable
            val number = number.text.toString()//Toma el numero
            val email = email.text.toString()//Toma el email
            if (name!="" || number!=""|| email!=""){//En caso de que los campos esten llenos
                contacts.add(Contact(name,number,email))//agrega el contacto
                Toast.makeText(applicationContext,"Has agregado a $name a tus contactos...",Toast.LENGTH_SHORT).show()//mensaje de extio
            }else{//Si no lleno todos los campos
                Toast.makeText(applicationContext,"No se pudo agregar contacto, llena todos los espacios...",Toast.LENGTH_SHORT).show()
            }
        }
    }

 }

