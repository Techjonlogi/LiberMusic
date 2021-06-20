package ClasesServicios

import com.example.libermusic.Conexiones
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor

class Servicios {


     companion object {
         fun getRestEngine():Retrofit{
    val interceptor = HttpLoggingInterceptor()
     interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
     val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
     val retrofit = Retrofit.Builder().baseUrl("https://4aba78516c08.ngrok.io")
             .addConverterFactory(GsonConverterFactory.create())
             .client(client).build()
     return retrofit
     }
 }
}






