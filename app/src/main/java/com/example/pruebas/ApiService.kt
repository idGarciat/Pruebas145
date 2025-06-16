package com.example.pruebas

import retrofit2.Call
import retrofit2.http.GET
interface ApiService {

    @GET("datos.php")
    fun obtenerDatos(): Call<DatosRespuesta>

    @GET("get_productos.php")
    fun obtenerProductos(): Call<List<DatosRespuesta>>

}