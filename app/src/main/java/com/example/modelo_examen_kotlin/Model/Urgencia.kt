package com.example.modelo_examen_kotlin.Model

enum class Urgencia {
    ALTA {
        override fun getColor() = "FF0000"
    },
    MEDIA {
        override  fun getColor() = "FFA500"
    },
    BAJA {
        override fun getColor() = "00FF00"
    };
    //FUNCION COMUN PARA LOS 3 TIPOS DE URGENCIA
    abstract fun getColor(): String
}