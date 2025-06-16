package com.example.pruebas

data class DatosRespuesta(
    val id_producto: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Int,
    val imagen: String,
    val stock: Int,
    val categoria: Int
)
