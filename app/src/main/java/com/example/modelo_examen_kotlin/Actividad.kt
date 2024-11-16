package com.example.modelo_examen_kotlin

open abstract class Actividad(
     nombre: String,
     completada: Boolean) {

    abstract val nombre: String
    abstract var completada: Boolean

    open fun marcarComoCompletada() {
        this.completada = true;
    }

    open fun mostrarDetalles() {
        println("Nombre: ${this.nombre} Completada: ${this.completada}")
    }
}