package com.example.modelo_examen_kotlin

import java.time.LocalDate

class Pago(
    override  var nombre: String,
    override var completada: Boolean,
    var cantiddad: Double,
    var fechaPago: LocalDate,
    var metodoPago: String
):Actividad(nombre,completada) {


    fun procesarPago() {

    }
    override fun mostrarDetalles() {

    }
}