package com.example.pruebas

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Response

class Activitysegundo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activitysegundo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val textviewrecuperado:TextView = findViewById(R.id.TextViewRecuperado)
        getData(textviewrecuperado)




    }
//Original ing
//    private fun getData(textViewR: TextView) {
//
//        val apiService = REST.getRestEngine().create(APIServices::class.java)
//        val result: Call<List<Posts>> = apiService.listPosts()
//
//        result.enqueue(object : retrofit2.Callback<List<Posts>> {
//            override fun onResponse(
//                call: Call<List<Posts>?>,
//                response: Response<List<Posts>?>
//            ) {
//                if(response.isSuccessful){
//                    textViewR.text = response.body().toString()
//                    Log.d("MainActivity", "Datos recuperados: ${response.body()}")
//                }else{
//                    Log.d("MainActivity", "Datos NO recuperados")
//                }
//            }
//
//            override fun onFailure(
//                call: Call<List<Posts>?>,
//                t: Throwable
//            ) {
//                Log.d("MainActivity", "Datos NO recuperados FALLO")
//            }
//        })
//
//
//
//
//    }


    //Chatgpt v1
//    private fun getData(textViewR: TextView) {
//        val apiService = REST.getRestEngine().create(APIServices::class.java)
//        val result: Call<DatosRespuesta> = apiService.obtenerDatos()
//
//        result.enqueue(object : retrofit2.Callback<DatosRespuesta> {
//            override fun onResponse(call: Call<DatosRespuesta>, response: Response<DatosRespuesta>) {
//                if (response.isSuccessful) {
//                    val datos = response.body()
//                    textViewR.text = "ID: ${datos?.id}, Nombre: ${datos?.nombre}, Valor: ${datos?.valor}"
//                    Log.d("MainActivity", "Datos recuperados: $datos")
//                } else {
//                    textViewR.text = "Error del servidor: ${response.code()}"
//                    Log.d("MainActivity", "Error: ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<DatosRespuesta>, t: Throwable) {
//                textViewR.text = "Fallo: ${t.message}"
//                Log.e("MainActivity", "Fallo: ${t.message}")
//            }
//        })
//    }



    private fun getData(textViewR: TextView) {
        val apiService = REST.getRestEngine().create(ApiService::class.java) // ← nombre corregido
        val call = apiService.obtenerProductos() // ← método que debe existir en ApiService.kt

        call.enqueue(object : retrofit2.Callback<List<DatosRespuesta>> {
            override fun onResponse(
                call: Call<List<DatosRespuesta>>,
                response: Response<List<DatosRespuesta>>
            ) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    val texto = StringBuilder()
                    productos?.forEach {
                        texto.append("ID: ${it.id_producto}, Nombre: ${it.nombre}, Precio: ${it.precio}\n")
                    }
                    textViewR.text = texto.toString()
                    Log.d("Activitysegundo", "Productos recuperados: $productos")
                } else {
                    textViewR.text = "Error en la respuesta: ${response.code()}"
                    Log.d("Activitysegundo", "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<DatosRespuesta>>, t: Throwable) {
                textViewR.text = "Fallo: ${t.message}"
                Log.e("Activitysegundo", "Fallo al conectar con API: ${t.message}")
            }
        })
    }





}