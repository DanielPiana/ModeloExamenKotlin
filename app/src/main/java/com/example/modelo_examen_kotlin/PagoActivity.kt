package com.example.modelo_examen_kotlin

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.modelo_examen_kotlin.Model.Pago
import java.time.LocalDate

class PagoActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.formulario_pago)

        var nombre = findViewById<EditText>(R.id.editTextnombreTarea)
        var cantidad = findViewById<EditText>(R.id.editTextCantidadPago)
        var boton = findViewById<Button>(R.id.buttonCrearTarea)

        boton.setOnClickListener {
            var pago = Pago(nombre.text.toString(),false,cantidad.text.toString().toDouble(),
                LocalDate.now(),"")
            pago.procesarPago(this)
            println(pago.completada)
        }
    }
}