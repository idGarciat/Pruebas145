package com.example.pruebas

class Operaciones {
    fun suma(a: Int, b: Int): Int {
        return a+b
    }
    fun resta(a: Int, b: Int): Int {
        return a-b
    }
    fun multiplicacion(a: Int, b: Int): Int {
        return a*b
    }
    fun division(a: Int, b: Int): Int {
        if (b == 0) {
            throw IllegalArgumentException("No se puede dividir entre cero")
        }
        return a / b
    }


}