package com.example.pruebas

import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    @GET("datos.php")  // Asegúrate que esta ruta exista en tu XAMPP
    fun obtenerDatos(): Call<DatosRespuesta>
}
