package com.example.libermusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import androidx.annotation.StringRes
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import ClasesServicios.*
import android.content.RestrictionEntry
import android.util.Log
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtusername = findViewById<EditText>(R.id.txtUsername)
        val password = findViewById<EditText>(R.id.txtpasword)
        val btnLogin = findViewById<Button>(R.id.btnlogin)
        val btnRegistro = findViewById<Button>(R.id.btnRegistrarse)
        var usuarioencontrado:RespuestaLogin?


        btnLogin.setOnClickListener() {
            var usuarioMandar: usuarioLogin = usuarioLogin()
            usuarioMandar.NombreDeUsuario = txtusername.text.toString()
            var contrasena:ContrasenaMandar = ContrasenaMandar()
            contrasena.contrasena1 = password.text.toString()
            usuarioMandar.contrasena = contrasena

            val conexiones:Conexiones = Servicios.getRestEngine().create(Conexiones::class.java)
            val result:Call<RespuestaLogin> = conexiones.hacerLogin(usuarioMandar)
            result.enqueue(object : Callback<RespuestaLogin>{
                override fun onFailure(call: Call<RespuestaLogin>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"Algo pasó",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<RespuestaLogin>,
                    response: Response<RespuestaLogin>
                ) {
                    usuarioencontrado = response?.body()
                    Toast.makeText(this@MainActivity,"Bienvenido al himalaya "+ usuarioencontrado?.datos?.usuario?.nombreDeUsuario,Toast.LENGTH_SHORT).show()
                    val ventanaCanciones:Intent = Intent(applicationContext,Canciones::class.java)
                    startActivity(ventanaCanciones)


                }

            })







        }







        btnRegistro.setOnClickListener(){

            val ventanaResgistro:Intent = Intent(applicationContext,Registrar::class.java)
            startActivity(ventanaResgistro)

        }
    }
}
