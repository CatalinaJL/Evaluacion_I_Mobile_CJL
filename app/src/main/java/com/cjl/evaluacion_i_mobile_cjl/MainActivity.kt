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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cjl.evaluacion_i_mobile_cjl.ui.theme.Evaluacion_I_Mobile_CJLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                InicioUI()
            }
        }
}

@Preview
@Composable
fun InicioUI(){

    val contexto = LocalContext.current

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement=Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Bienvenido a Remu-App, la app que calcula remuneraciones")
        Spacer(modifier = Modifier.height(20.dp))
        Text("Selecciona la opción que deseas calcular:")

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(contexto, CalculoHonorarios::class.java)
            contexto.startActivity(intent)
        }){
            Text("Remuneracion Honorarios")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(contexto, CalculoContrato::class.java)
            contexto.startActivity(intent)
        }){
            Text("Remuneracion Contrato")
        }
    }
}

abstract class Empleado{

    abstract fun calcularLiquido():Double

}




