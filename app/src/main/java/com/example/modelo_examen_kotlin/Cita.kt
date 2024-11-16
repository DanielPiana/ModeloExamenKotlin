package com.example.modelo_examen_kotlin

import java.time.LocalDateTime

class Cita(
    override var nombre: String,
    override var completada: Boolean,
    var fechaHora: LocalDateTime,
    var lugar: String,
    var personas : List<Persona>? ):Actividad(nombre, completada), Recordatorio {

    fun agregarPersona (persona: Persona): Unit {

    }
    override fun mostrarDetalles() {
    }

    override fun programarRecordatorio() {
        TODO("Not yet implemented")
    }

    override fun cancelarRecordatorio() {
        TODO("Not yet implemented")
    }
}