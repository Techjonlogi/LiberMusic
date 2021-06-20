package com.example.libermusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)


        val txtnombre = findViewById<EditText>(R.id.txtnombre)
        val txtPais = findViewById<EditText>(R.id.txtPais)
        val txtUsername = findViewById<EditText>(R.id.txtUsernameRegistro)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val contrasena = findViewById<EditText>(R.id.txtPassword)
        val contrasenaRepite = findViewById<EditText>(R.id.txtPassworsRepite)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)


        btnRegistro.setOnClickListener {

            //btnLoginTask().execute(txtusername.text.toString(), password.text.toString())
        }

        btnRegresar.setOnClickListener {

            val ventanaLogin: Intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(ventanaLogin)
        }


    }
}