package com.example.libermusic

import ClasesServicios.*
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)


        val txtnombre = findViewById<EditText>(R.id.txtnombre)
        val txtPais = findViewById<EditText>(R.id.txtPais)
        val txtUsername = findViewById<EditText>(R.id.txtUsernameRegistro)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtcontrasena = findViewById<EditText>(R.id.txtPassword)
        val contrasenaRepite = findViewById<EditText>(R.id.txtPassworsRepite)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)


        btnRegistro.setOnClickListener {
    var usuarioRegistrar:UsuarioRegistrar = UsuarioRegistrar()
            usuarioRegistrar.nombreDeUsuario = txtUsername.text.toString()
            usuarioRegistrar.nombreDelPropietario = txtnombre.text.toString()
            usuarioRegistrar.FKIdEstatus = 1


            var contrasena = Contrasena()
            contrasena.Contrasena1 = txtcontrasena.text.toString()
            contrasena.FKIdUsuario = ""
            usuarioRegistrar.contrasena = contrasena

            var datos = DatosDeLocalizacion()
            datos.FKIdUsuario = ""
            datos.Email = txtCorreo.text.toString()
            datos.Pais = txtPais.text.toString()
            usuarioRegistrar.DatosDeLocalizacion = datos





            val conexiones:Conexiones = Servicios.getRestEngine().create(Conexiones::class.java)
            val result:Call<RespuestaUsuarioRegistro> = conexiones.RegistrarUsuario(usuarioRegistrar)
            result.enqueue(object : Callback<RespuestaUsuarioRegistro>{
                override fun onFailure(call: Call<RespuestaUsuarioRegistro>, t: Throwable) {
                    Toast.makeText( this@Registrar,"Algo paso al registrar", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<RespuestaUsuarioRegistro>,
                    response: Response<RespuestaUsuarioRegistro>
                ) {
                    Toast.makeText( this@Registrar,"Registrado con Exito", Toast.LENGTH_SHORT).show()
                    val ventanaLogin: Intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(ventanaLogin)
                }


            })



        }

        btnRegresar.setOnClickListener {

            val ventanaLogin: Intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(ventanaLogin)
        }













    }
}