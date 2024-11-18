package com.example.modelo_examen_kotlin

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.modelo_examen_kotlin.Model.Tarea
import com.example.modelo_examen_kotlin.Model.Urgencia
import java.time.LocalDate

class TareaActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.formulario_tarea)
        var nombre = findViewById<EditText>(R.id.editTextnombreTarea)
        var radio_group = findViewById<RadioGroup>(R.id.radioGroupUrgencia)
        var boton = findViewById<Button>(R.id.buttonCrearTarea)
        lateinit var radioSeleccionado:RadioButton
        var calendario = findViewById<CalendarView>(R.id.calendarView)
        lateinit var fechaSeleccionada: LocalDate
        lateinit var urgencia:Urgencia

        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            fechaSeleccionada = LocalDate.of(year, month + 1, dayOfMonth)
        }
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            radioSeleccionado = findViewById(checkedId)
            when (checkedId) {
                R.id.radioButtonBaja -> urgencia = Urgencia.BAJA
                R.id.radioButtonMedia -> urgencia = Urgencia.MEDIA
                R.id.radioButtonAlta -> urgencia = Urgencia.ALTA
            }
        }

        boton.setOnClickListener {
            var tarea = Tarea(nombre.text.toString(),false,fechaSeleccionada,urgencia,null)
            tarea.mostrarDetalles()
            tarea.añadirTarea(tarea,this)
            tarea.imprimirTareas()
        }
    }
}