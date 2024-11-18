package com.example.modelo_examen_kotlin.Model

import android.content.Context
import com.example.modelo_examen_kotlin.extensiones.funcionSuperior
import com.example.modelo_examen_kotlin.extensiones.toast
import java.time.LocalDateTime

class Cita(
    override var nombre: String,
    override var completada: Boolean,
    var fechaHora: LocalDateTime,
    var lugar: String,
    var personas : ArrayList<Persona>? ) : Actividad(nombre, completada), Recordatorio {
        companion object {
            var listaCitas = ArrayList<Actividad>()
        }


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

    fun imprimirCitas() {
        listaCitas.forEachIndexed { index, cita ->
            println("Cita $index: ${cita.mostrarDetalles()}")
        }
        println("Total de citas: ${listaCitas.size}")
    }


    fun añadirCita(cita: Cita,context: Context) {
        // GUARDAMOS EN CITAEXISTENTE UNA CITA SI COINCIDE CON LOS PARAMETROS DE BUSQUEDA
        //DONDE DEVUELVE TRUE, ES QUE COINCIDE Y SE GUARDA EN CITA EXISTENTE,
        //DEBAJO COMPROBAMOS SI ESTA VACIO O NO PARA AGREGAR LA CITA O NO.
        val citaExistente = listaCitas.funcionSuperior {
            if (it is Cita) {
                if (it.fechaHora == cita.fechaHora) {
                    return@funcionSuperior true
                } else {
                    return@funcionSuperior false
                }
            } else {
                return@funcionSuperior false
            }
        }
        if (citaExistente.isEmpty()) {
            listaCitas.add(cita)
            context.toast("Cita añadida correctamente")
        } else {
            context.toast("Esa fecha y hora no esta disponible")
        }
    }

    override fun programarRecordatorio(context: Context, mensaje: String) {
        TODO("Not yet implemented")
    }

    override fun cancelarRecordatorio(context: Context, notificacion: Tarea.Notificacion?) {
        TODO("Not yet implemented")
    }
}