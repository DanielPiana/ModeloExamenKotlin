package com.example.modelo_examen_kotlin

import android.content.Context
import java.time.LocalDateTime

class Cita(
    override var nombre: String,
    override var completada: Boolean,
    var fechaHora: LocalDateTime,
    var lugar: String,
    var personas : ArrayList<Persona>? ) :Actividad(nombre, completada), Recordatorio {

    fun agregarPersonaCita (persona: Persona): Unit {
        personas?.add(persona)
    }
    override fun mostrarDetalles():String {
        return "Cita: ${nombre} " +
                "Completada: ${completada} " +
                "Fecha y hora: ${fechaHora} " +
                "Lugar: ${lugar} " +
                "Personas: ${personas.toString()}"
    }

    override fun programarRecordatorio(context: Context, mensaje: String) {
        TODO("Not yet implemented")
    }

    override fun cancelarRecordatorio(context: Context, notificacion: Tarea.Notificacion?) {
        TODO("Not yet implemented")
    }
}