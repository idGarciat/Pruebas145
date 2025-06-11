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

    private fun getData(textViewR: TextView) {

        val apiService = REST.getRestEngine().create(APIServices::class.java)
        val result: Call<List<Posts>> = apiService.listPosts()

        result.enqueue(object : retrofit2.Callback<List<Posts>> {
            override fun onResponse(
                call: Call<List<Posts>?>,
                response: Response<List<Posts>?>
            ) {
                if(response.isSuccessful){
                    textViewR.text = response.body().toString()
                    Log.d("MainActivity", "Datos recuperados: ${response.body()}")
                }else{
                    Log.d("MainActivity", "Datos NO recuperados")
                }
            }

            override fun onFailure(
                call: Call<List<Posts>?>,
                t: Throwable
            ) {
                Log.d("MainActivity", "Datos NO recuperados FALLO")
            }
        })




    }
}