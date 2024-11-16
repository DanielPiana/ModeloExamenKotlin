package com.example.modelo_examen_kotlin.Model

import android.content.Context
import android.widget.Toast
import java.time.LocalDate
import java.time.LocalDateTime
import com.example.modelo_examen_kotlin.extensiones.*

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
        context.toast(mensaje)
    }

    override fun cancelarRecordatorio(context:Context, notificacion: Notificacion?) {
        if (notificacion == null) {
            context.toast("No existe este recordatorio")
        } else if (notificacion.activo) {
            this.notificacion = null
            context.toast("Recordatorio cancelaco correctamente")
        } else {
            context.toast("Ese recordatorio ya está desactivado")
        }
    }

    inner class Notificacion(
        var fecha_hora_notificacion: LocalDateTime,
        var activo: Boolean) {

        fun mostrarNotificacion(context: Context) {
            if (!this.activo) {
                context.toast("La notificación no está activada")
            } else {
                context.toast("Hora: ${this.fecha_hora_notificacion}",Toast.LENGTH_LONG)
            }
        }
    }
}
