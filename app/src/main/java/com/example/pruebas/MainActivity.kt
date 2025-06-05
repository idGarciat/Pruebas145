package com.example.pruebas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declarando variables con los botones
        val botondesalir = findViewById<Button>(R.id.botonsalir)
        val botondeinicio = findViewById<Button>(R.id.botoninicio)
        val botonadmin = findViewById<Button>(R.id.botonadmin)
        val botonmapa = findViewById<Button>(R.id.botonmapa)

        //Funcion de los botones
        botondesalir.setOnClickListener {
            botondesalir.text = "Adios"
            finish()
            //Cierra la aplicacion

        }

        botondeinicio.setOnClickListener {
            //Ventana emergente al hacer click en el boton
            //O por lo menos eso deberia salir
            val intent = Intent(MainActivity@this, mainscreen::class.java)
            startActivity(intent)

        }

        botonadmin.setOnClickListener {
            //Ventana emergente al hacer click en el boton
            //O por lo menos eso deberia salir
            val intent = Intent(MainActivity@this, AdminScreen::class.java)
            startActivity(intent)
        }

        botonmapa.setOnClickListener {
            //Ventana emergente al hacer click en el boton
            //O por lo menos eso deberia salir
            val intent = Intent(MainActivity@this, MapsActivity::class.java)
            startActivity(intent)
        }





    }
}