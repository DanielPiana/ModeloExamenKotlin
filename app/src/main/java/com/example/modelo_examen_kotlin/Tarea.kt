package com.example.modelo_examen_kotlin

import android.content.Context
import android.widget.Toast
import java.time.LocalDate
import java.time.LocalDateTime

class Tarea(
    override var nombre: String,
    override var completada: Boolean,
    var fecha_limite: LocalDate?,
    var urgencia: Urgencia,
    var notificacion: Notificacion?
    ) : Actividad(nombre, completada), Recordatorio {

    override fun marcarComoCompletada() {
        this.completada = true;
    }

    override fun mostrarDetalles():String {
        return "Nombre: ${this.nombre} " +
                "Completada: ${this.completada} " +
                "Fecha límite: ${fecha_limite} " +
                "Urgencia: ${urgencia} " +
                "Hora de notificación: ${notificacion?.fecha_hora_notificacion} " +
                "¿Notificación activa? ${notificacion?.activo}"
    }

    override fun programarRecordatorio(context: Context, mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun cancelarRecordatorio(context:Context, notificacion: Notificacion?) {
        if (notificacion == null) {
            Toast.makeText(context,"No existe este recordatorio", Toast.LENGTH_SHORT).show()
        } else if (notificacion.activo) {
            this.notificacion = null
            Toast.makeText(context,"Recordatorio cancelaco correctamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context,"Ese recordatorio ya está desactivado", Toast.LENGTH_SHORT).show()
        }
    }

    inner class Notificacion(
        var fecha_hora_notificacion: LocalDateTime,
        var activo: Boolean) {

        fun mostrarNotificacion(context: Context) {
            if (!this.activo) {
                Toast.makeText(context,"La notificación no está activada",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context,"Hora: ${this.fecha_hora_notificacion}",Toast.LENGTH_LONG).show()
            }
        }
    }
}
