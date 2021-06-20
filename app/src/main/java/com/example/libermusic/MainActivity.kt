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


        btnLogin.setOnClickListener {


            var contrasenamandar: ContrasenaMandar = ContrasenaMandar()
            contrasenamandar.contrasena1 = password.text.toString()
            var usuarioLogin: usuarioLogin = usuarioLogin()
            usuarioLogin.contrasena = contrasenamandar
            usuarioLogin.NombreDeUsuario = txtusername.text.toString()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://4a15f1f9503f.ngrok.io/LoginApi/doLogin")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create<Conexiones>(Conexiones::class.java)

            service.Login(usuarioLogin, usuarioLogin)
                .enqueue(object : Callback<DatosRespuestaUsuario> {
                    override fun onResponse(
                        call: Call<DatosRespuestaUsuario>?,
                        response: Response<DatosRespuestaUsuario>?

                    ) {
                        val post = response?.body()

                    }

                    override fun onFailure(call: Call<DatosRespuestaUsuario>?, t: Throwable?) {
                        t?.printStackTrace()
                    }
                })

        }
    }
}
