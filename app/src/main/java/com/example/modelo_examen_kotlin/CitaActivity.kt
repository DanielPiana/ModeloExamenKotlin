package com.example.modelo_examen_kotlin

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.modelo_examen_kotlin.Model.Cita
import com.example.modelo_examen_kotlin.Model.Persona
import java.time.LocalDateTime

class CitaActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.formulario_cita)

        var nombre = findViewById<EditText>(R.id.editTextNombreCita)
        var lugar = findViewById<EditText>(R.id.editTextLugarCita)
        var boton = findViewById<Button>(R.id.buttonCrearCita)
        var listaPersonas = ArrayList<Persona>()

        boton.setOnClickListener {
            var cita = Cita(nombre.text.toString(),false, LocalDateTime.now(),lugar.text.toString(),listaPersonas)
            cita.añadirCita(cita,this)
            cita.imprimirCitas()
        }
    }
}