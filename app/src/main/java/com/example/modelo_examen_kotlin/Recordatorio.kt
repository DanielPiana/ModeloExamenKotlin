package com.example.modelo_examen_kotlin

import android.content.Context
import com.example.modelo_examen_kotlin.Tarea.Notificacion

interface Recordatorio {

    fun programarRecordatorio(context: Context, mensaje: String)

    fun cancelarRecordatorio(context:Context,notificacion: Notificacion?)
}