package com.cjl.evaluacion_i_mobile_cjl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.compose.ui.text.input.TextFieldValue

class CalculoContrato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_contrato)

        val btnInicio= findViewById<Button>(R.id.btnInicio)
        btnInicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

       // val btnCalculoContrato = findViewById<Button>(R.id.btnCalculoCtto)
       // btnCalculoContrato.setOnClickListener {

       // }

    }
}

class EmpleadoRegular(val sueldoBruto:Double):Empleado(){
    override fun calcularLiquido(): Double {
        return sueldoBruto * 0.20
    }
}
