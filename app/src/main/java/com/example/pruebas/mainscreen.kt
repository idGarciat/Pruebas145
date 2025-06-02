package com.example.pruebas

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Button
import android.widget.EditText
import androidx.core.view.WindowInsetsCompat


class mainscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val caja1:EditText = findViewById<EditText>(R.id.caja1)
        val caja2:EditText = findViewById<EditText>(R.id.caja2)
        val botonSumar = findViewById<Button>(R.id.botonSuma)
        val botonRestar = findViewById<Button>(R.id.botonresta)
        val botonMultiplicar = findViewById<Button>(R.id.botonmultiplicacion)
        val botonDividir = findViewById<Button>(R.id.botondivision)
        val botonInicio = findViewById<Button>(R.id.botoninicio)

        botonInicio.setOnClickListener {
            val intent = Intent(MainActivity@this, MainActivity::class.java)
            startActivity(intent)
        }

        val resultado = findViewById<TextView>(R.id.resultado)

        botonSumar.setOnClickListener {
            val operaciones = Operaciones()
            val num1 = caja1.text.toString().toFloatOrNull()
            val num2 = caja2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                val suma = Operaciones().suma(num1, num2)
                resultado.text = "Resultado: $suma"
            } else {
                resultado.text = "Por favor, ingrese números válidos."
            }
        }

        botonRestar.setOnClickListener {
            val operaciones = Operaciones()
            val num1 = caja1.text.toString().toFloatOrNull()
            val num2 = caja2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                val resta = Operaciones().resta(num1, num2)
                resultado.text = "Resultado: $resta"
            } else {
                resultado.text = "Por favor, ingrese números válidos."
            }
        }

        botonMultiplicar.setOnClickListener {
            val operaciones = Operaciones()
            val num1 = caja1.text.toString().toFloatOrNull()
            val num2 = caja2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                val multiplicacion = Operaciones().multiplicacion(num1, num2)
                resultado.text = "Resultado: $multiplicacion"
            } else {
                resultado.text = "Por favor, ingrese números válidos."
            }
        }

        botonDividir.setOnClickListener {
            val operaciones = Operaciones()
            val num1 = caja1.text.toString().toFloatOrNull()
            val num2 = caja2.text.toString().toFloatOrNull()

            if (num1 != null && num2 != null) {
                try {
                    val division = Operaciones().division(num1, num2)
                    resultado.text = "Resultado: $division"
                } catch (e: IllegalArgumentException) {
                    resultado.text = e.message
                }
            } else {
                resultado.text = "Por favor, ingrese números válidos."
            }
        }


    }
}