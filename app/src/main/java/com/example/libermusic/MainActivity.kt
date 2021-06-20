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

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtusername = findViewById<EditText>(R.id.txtUsername)
        val password = findViewById<EditText>(R.id.txtpasword)
        val btnLogin = findViewById<Button>(R.id.btnlogin)

        btnLogin.setOnClickListener {

            //btnLoginTask().execute(txtusername.text.toString(), password.text.toString())
        }

    }

}
