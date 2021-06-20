package com.example.libermusic
import ClasesServicios.DatosRespuestaUsuario
import ClasesServicios.UsuarioRegistrar
import ClasesServicios.usuarioLogin
import org.json.JSONObject
import retrofit2.*;
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

public interface Conexiones {
    @GET(value = "posts/")
    fun RegresarUsuario(): Call<DatosRespuestaUsuario>
   @POST(value = "posts")
   fun Login(usuarioMandar:usuarioLogin,@Body usuarioMan: usuarioLogin): Call<DatosRespuestaUsuario>





}
