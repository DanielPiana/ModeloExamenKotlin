package com.example.modelo_examen_kotlin.Model

import android.content.Context
import android.widget.Toast
import com.example.modelo_examen_kotlin.Model.Cita.Companion.listaCitas
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
    companion object {
        var listaTareas = ArrayList<Actividad>()
    }

    override fun marcarComoCompletada() {
        this.completada = true;
    }

    override fun mostrarDetalles(): String {
        return "Nombre: ${this.nombre} " +
                "Completada: ${this.completada} " +
                "Fecha limite: ${fecha_limite} " +
                "Urgencia: ${urgencia} " +
                "Hora de notificacion: ${notificacion?.fecha_hora_notificacion} " +
                "¿Notificacion activa? ${notificacion?.activo}"
    }

    override fun programarRecordatorio(context: Context, mensaje: String) {
        context.toast(mensaje)
    }

    override fun cancelarRecordatorio(context: Context, notificacion: Notificacion?) {
        if (notificacion == null) {
            context.toast("No existe este recordatorio")
        } else if (notificacion.activo) {
            this.notificacion = null
            context.toast("Recordatorio cancelaco correctamente")
        } else {
            context.toast("Ese recordatorio ya está desactivado")
        }
    }

    fun crearNotificacion(fecha: LocalDateTime, activo: Boolean): Notificacion {
        val nuevaNotificacion = Notificacion(fecha, activo)
        this.notificacion = nuevaNotificacion
        return nuevaNotificacion
    }

    fun añadirTarea(tarea: Tarea, context: Context) {
        val tareaExistente = listaTareas.funcionSuperior {
            //NOS ASEGURAMOS DE QUE SEA TAREA, PARA PODER ACCEDER A LOS ATRIBUTOS CONCRETOS DE LA CLASE TAREA
            if (it is Tarea) {
                if (it.nombre == tarea.nombre) { //SI COINCIDE CON ALGUNA DE LA LISTA, DEVOLVEMOS TRUE (ESTO HACE QUE LA FUNCION LAMBDA
                    //GUARDE EN tareaExistente LA TAREA QUE HAYA COINCIDIDO
                    return@funcionSuperior true
                } else {
                    return@funcionSuperior false
                }
            } else {
                return@funcionSuperior false
            }
        }
        if (tareaExistente.isEmpty()) {
            listaTareas.add(tarea)
            context.toast("Tarea añadida correctamente")
        } else context.toast("Una tarea con ese nombre ya existe")
    }
    fun imprimirTareas() {
        listaTareas.forEachIndexed { index, tarea ->
            println("Tarea $index: ${tarea.mostrarDetalles()}")
        }
        println("Total de tareas: ${listaTareas.size}")
    }

    inner class Notificacion(
        var fecha_hora_notificacion: LocalDateTime,
        var activo: Boolean
    ) {

        fun mostrarNotificacion(context: Context) {
            if (!this.activo) {
                context.toast("La notificación no está activada")
            } else {
                context.toast("Hora: ${this.fecha_hora_notificacion}", Toast.LENGTH_LONG)
            }
        }
    }
}
