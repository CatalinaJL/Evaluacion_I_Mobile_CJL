package com.cjl.evaluacion_i_mobile_cjl

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.math.BigInteger

class CalculoHonorarios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                CalculusHonorariesUI()
            }
        }
}

@Composable
@Preview
fun CalculusHonorariesUI() {
    // Para trabajar con Intent y poder hacer el paso a la pantalla inicio
    val contexto = LocalContext.current
    // Para poder obtener el valor del TextField, o sea obtener el sueldo bruto
    var sueldoBruto by remember { mutableStateOf(" ") }
    // Variable para guardar sueldo liquido
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Text("Ingrese el sueldo del trabajador:")
        Text(text = "Ingrese el sueldo bruto:")

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = " ",
            onValueChange = { sueldoBruto = it},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )

        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val sueldoB= sueldoBruto.toDoubleOrNull() ?:0
            val sueldoLiquido = EmpleadoHonorarios(sueldoB as Double).calcularLiquido()
            resultado = "El sueldo liquido es: $sueldoLiquido"

        }) {
            Text(text = "Calculo Remuneración Liquida")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(resultado)

        Spacer(modifier = Modifier.height(80.dp))
        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        }){
            Text("Inicio")
        }

    }

}


class EmpleadoHonorarios(val sueldoBruto: Double):Empleado(){
    override fun calcularLiquido(): Double {
        val montoDescuento = sueldoBruto * 0.13
        return  sueldoBruto -  montoDescuento
    }
}








