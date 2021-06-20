package com.example.libermusic
import ClasesServicios.*
import org.json.JSONObject
import retrofit2.*;
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

public interface Conexiones {

    @POST("LoginApi/doLogin")
    fun hacerLogin(@Body usuario:usuarioLogin?):Call<RespuestaLogin>

    @POST("Registrar/RegistrarUsuario")
    fun RegistrarUsuario(@Body usuario:UsuarioRegistrar?):Call<RespuestaUsuarioRegistro>




}
