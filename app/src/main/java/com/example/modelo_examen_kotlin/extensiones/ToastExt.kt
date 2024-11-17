package com.example.modelo_examen_kotlin.extensiones

import android.content.Context
import android.widget.Toast
import com.example.modelo_examen_kotlin.Model.Actividad
import com.example.modelo_examen_kotlin.Model.Pago


fun Context.toast (mensaje:String, duracion: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,mensaje,duracion).show()
}

/*TODO ArrayList<Actividad>.funcionSuperior */// es una funcion que extiende de ArrayList<Actividad>, basicamente solo pueden usarla los Arraylists de Actividades.
/*TODO funLambda: (actividad: Actividad) -> Boolean */// Parametro que es una función
/*TODO :ArrayList<Actividad> */// Devuelve una lista de actividades.
/*TODO return ArrayList(this.filter(funLambda)) */// this se refiere a la lista de actividades que ha invocado a la funcion superior
                                            ///.filter porque la usamos para filtrar con un criterio concreto que esta definido en funFiltrar
                                            /// el criterio por el que se filtra, se define cuando llamas a la funcion superior.
fun ArrayList<Actividad>.funcionSuperior(funFiltrar: (actividad: Actividad) -> Boolean):ArrayList<Actividad> {
    return ArrayList(this.filter(funFiltrar))
}


fun ArrayList<Pago>.funcionSuperiorPago(funcion: (pago:Pago) -> Double): Double {
    return this.sumOf(funcion)
}
