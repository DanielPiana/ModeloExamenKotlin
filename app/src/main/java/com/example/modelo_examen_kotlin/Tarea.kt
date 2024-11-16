package com.example.modelo_examen_kotlin

import java.time.LocalDate
import java.time.LocalDateTime

class Tarea(
    override var nombre: String,
    override var completada: Boolean,
    var fecha_limite: LocalDate,
    var urgencia: Urgencia,
    var notificacion: Notificacion?
    ) : Actividad(nombre, completada), Recordatorio {

    override fun marcarComoCompletada() {
        this.completada = true;
    }

    override fun mostrarDetalles() {
        println("Nombre: ${this.nombre} Completada: ${this.completada}")
    }

    override fun programarRecordatorio() {
        TODO("Not yet implemented")
    }

    override fun cancelarRecordatorio() {
        TODO("Not yet implemented")
    }

    inner class Notificacion(
        fecha_hora_notificacion: LocalDateTime,
        activo: Boolean) {

        fun mostrarNotificacion() {

        }
    }
}
