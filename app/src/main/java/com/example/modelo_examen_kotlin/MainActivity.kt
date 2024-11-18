package com.example.modelo_examen_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var buttonElegir = findViewById<Button>(R.id.buttonElegir)
        lateinit var radioButtonSeleccionado: RadioButton
        lateinit var activity: Class<*>


        var radiogroup = findViewById<RadioGroup>(R.id.radioGroup)
        //CUANDO CAMBIA EL RADIOBUTTON SELECCIONADO DEL RADIOGROUP, SE GUARDA EN checkedId
        radiogroup.setOnCheckedChangeListener { group, checkedId ->
            //COJO EL RADIOBUTTON SELECCIONADO (checkedId)
            radioButtonSeleccionado = findViewById(checkedId)

            when (checkedId) {
                R.id.rbCita -> activity = CitaActivity::class.java
                R.id.rbTarea -> activity = TareaActivity::class.java
                R.id.rbPago -> activity = PagoActivity::class.java
            }
        }

        buttonElegir.setOnClickListener {
            val intent = Intent(this, activity)
            startActivity(intent)
        }

    }
}














        /*val listaPersonas = ArrayList<Persona>()
        var persona1 = Persona("persona1", "1")
        var persona2 = Persona("persona2", "2")
        var persona3 = Persona("persona3", "3")
        listaPersonas.add(persona1)
        listaPersonas.add(persona2)
        listaPersonas.add(persona3)

        val listaCitas = ArrayList<Actividad>()
        var actividad1 = Cita("Ana", false, LocalDateTime.now(), "lugar1", listaPersonas)
        var actividad2 = Cita("Ana", true, LocalDateTime.now(), "lugar2", listaPersonas)
        var actividad3 = Cita("Paco", true, LocalDateTime.now(), "lugar3", listaPersonas)
        var actividad4 = Cita("Ana", false, LocalDateTime.now(), "lugar4", listaPersonas)
        listaCitas.add(actividad1)
        listaCitas.add(actividad2)
        listaCitas.add(actividad3)
        listaCitas.add(actividad4)

        /*TODO// NO SE NECESITA BUCLE PARA FUNCION LAMBDA, HACE INTERNAMENTE UNA ITERACION DE
        *  CADA ELEMENTO DE LA LISTA, IT REFERENCIA A LA ACTIVIDADACTUAL*/
        val resultadoAna = listaCitas.funcionSuperior {
            it.nombre.equals("Ana")
        }

        val listaTareas = ArrayList<Actividad>()

        //CREO UNA TAREA
        var actividadtarea1 = Tarea("tarea1", true, LocalDate.now(), Urgencia.ALTA, null)
        //CREO UNA NOTIFICACION, COMO ES INNER CLASS DE TAREA, NECESITO UNA INSTANCIA DE TAREA PARA PODER CREAR UNA NOTIFICACION
        //var notificacion = actividadtarea1.Notificacion(LocalDateTime.now(),true)
        var notificacion = actividadtarea1.crearNotificacion(LocalDateTime.now(), true)

        var actividadtarea2 = Tarea("tarea1", true, LocalDate.now(), Urgencia.ALTA, null)
        var actividadtarea3 = Tarea("tarea1", true, LocalDate.now(), Urgencia.MEDIA, null)
        var actividadtarea4 = Tarea("tarea1", true, LocalDate.now(), Urgencia.MEDIA, null)
        var actividadtarea5 = Tarea("tarea1", true, LocalDate.now(), Urgencia.BAJA, null)
        var actividadtarea6 = Tarea("tarea1", true, LocalDate.now(), Urgencia.BAJA, null)
        listaTareas.add(actividadtarea1)
        listaTareas.add(actividadtarea2)
        listaTareas.add(actividadtarea3)
        listaTareas.add(actividadtarea4)
        listaTareas.add(actividadtarea5)
        listaTareas.add(actividadtarea6)


        val resultadoUrgencia = listaTareas.funcionSuperior {
            if (it is Tarea) {
                it.urgencia == Urgencia.ALTA
            } else {
                false
            }
        }
        println(resultadoUrgencia)

        val listaPagos = ArrayList<Pago>()
        var pago1 = Pago("pago1", true, 100.0, LocalDate.now(), "Efectivo")
        var pago2 = Pago("pago2", true, 150.0, LocalDate.now(), "Tarjeta")
        var pago3 = Pago("pago3", false, 10.0, LocalDate.now(), "Tarjeta")
        var pago4 = Pago("pago4", false, 1500.0, LocalDate.now(), "Tarjeta")
        var pago5 = Pago("pago5", true, 130.0, LocalDate.now(), "Efectivo")
        var pago6 = Pago("pago6", false, 120.0, LocalDate.now(), "Efectivo")

        listaPagos.add(pago1)
        listaPagos.add(pago2)
        listaPagos.add(pago3)
        listaPagos.add(pago4)
        listaPagos.add(pago5)
        listaPagos.add(pago6)

        val sumaDePagos: Double = listaPagos.funcionSuperiorPago {
            //if (it.completada) it.cantidad else 0.0
            if (it.completada){
                it.cantidad
            } else {
                0.0
            }
        }
        println(sumaDePagos)

        val sumaDePagos2024:Double = listaPagos.funcionSuperiorPago {
            // if (it.fechaPago.year == 2024) it.cantidad else 0.0
            if (it.fechaPago.year == 2024) {
                it.cantidad
            } else  {
                0.0
            }
        }
        println(sumaDePagos2024)

*/
