package com.example.modelo_examen_kotlin.Model

import android.content.Context
import com.example.modelo_examen_kotlin.Model.Tarea.Notificacion

interface Recordatorio {

    fun programarRecordatorio(context: Context, mensaje: String)

    fun cancelarRecordatorio(context:Context,notificacion: Notificacion?)
}