package com.example.pruebas

class Operaciones {
    fun suma(a: Float, b: Float): Float {
        return a+b
    }
    fun resta(a: Float, b: Float): Float {
        return a-b
    }
    fun multiplicacion(a: Float, b: Float): Float {
        return a*b
    }
    fun division(a: Float, b: Float): Float {
        if (b <= 0) {
            throw IllegalArgumentException("No se puede dividir entre cero")
        }
        return a / b
    }


}