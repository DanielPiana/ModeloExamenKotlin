package com.example.modelo_examen_kotlin.extensiones

import android.content.Context
import android.widget.Toast
import com.example.modelo_examen_kotlin.Model.Actividad


fun Context.toast (mensaje:String, duracion: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,mensaje,duracion).show()
}


fun ArrayList<Actividad>.funcionSuperior(funLambda: (actividad: Actividad) -> Boolean):ArrayList<Actividad> {
    return ArrayList()
}
