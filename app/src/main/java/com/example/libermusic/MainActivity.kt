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
        val btnRegistro = findViewById<Button>(R.id.btnRegistrarse)


        btnLogin.setOnClickListener() {




        }

        btnRegistro.setOnClickListener(){

            val ventanaResgistro:Intent = Intent(applicationContext,Registrar::class.java)
            startActivity(ventanaResgistro)

        }
    }
}
