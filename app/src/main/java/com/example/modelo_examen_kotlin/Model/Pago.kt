package com.example.modelo_examen_kotlin.Model

import android.content.Context
import android.widget.Toast
import java.time.LocalDate
import com.example.modelo_examen_kotlin.extensiones.*

class Pago(
    override  var nombre: String,
    override var completada: Boolean,
    var cantidad: Double,
    var fechaPago: LocalDate,
    var metodoPago: String
): Actividad(nombre,completada) {

    fun procesarPago(context: Context) {
        this.marcarComoCompletada()
        context.toast("Pago procesado", Toast.LENGTH_LONG)
    }
    override fun mostrarDetalles():String {
        return "Nombre: ${nombre} " +
                "¿Completado?: ${completada} " +
                "Cantidad: ${cantidad} " +
                "Fecha de pago: ${fechaPago} " +
                "Método de pago: ${metodoPago} "
    }
}