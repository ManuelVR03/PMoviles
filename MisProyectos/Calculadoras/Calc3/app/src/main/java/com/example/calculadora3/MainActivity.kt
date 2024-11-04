package com.example.calculadora3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora3.ui.theme.Calculadora3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculadora(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Botonera3(calculadora: Calculadora, estadoPantalla: EstadoPantalla){
    Column {
        var numeros = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        var id = 0
        for (i in 1..3){
            Row {
                for (j in 1..3){
                    var num = numeros[id]
                    Button(onClick = { gestionBotonesRef(num, calculadora, estadoPantalla) }) {
                        Text(
                            text = num
                        )
                    }
                    id++
                }
            }
        }
        Row {
            Button(onClick = {calculadora.reset()
            estadoPantalla.pantalla=""}) { Text(text = "C") }
            Button(onClick = { gestionBotonesRef("0", calculadora, estadoPantalla) }) {
                Text(text = "0")
            }
            Button(onClick = {estadoPantalla.pantalla = calculadora.resuelveAddOperacion()}) { Text(text = "=") }
        }
    }
}

@Composable
fun BotonesOperacion3(calculadora: Calculadora, estadoPantalla: EstadoPantalla){
    val operaciones = listOf("+" to "suma", "-" to "resta", "x" to "multiplica", "/" to "divide", "^2" to "cuadrado", "Raíz" to "raizCuadrada")
    Column {
        operaciones.forEach { (simbolo, operacion) ->
            Button(onClick = {estadoPantalla.pantalla = calculadora.resuelveAddOperacion(operacion)}) { Text(text = simbolo) }
        }
    }
}

fun gestionBotonesRef( s: String, calculadora:Calculadora, estadoPantalla:EstadoPantalla) {

    var n = s.toDouble()
    if (calculadora.operacion == "") {
        calculadora.operando1 = (calculadora.operando1 * 10) + n
        estadoPantalla.pantalla=""+calculadora.operando1

    } else {
        calculadora.operando2 = (calculadora.operando2 * 10) + n
        estadoPantalla.pantalla=""+calculadora.operando2
    }
}

class EstadoPantalla(){
    var pantalla by mutableStateOf("0")
}

@Composable
fun Calculadora(name: String, modifier: Modifier = Modifier) {
    var calculadora: Calculadora by remember { mutableStateOf(Calculadora())}
    var estadoPantalla = remember {EstadoPantalla()}
    Column {
        Text(
            text = estadoPantalla.pantalla,
            fontSize = 24.sp,modifier = Modifier.fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black))
                .padding(16.dp)
                .padding(top = 50.dp),textAlign = TextAlign.End
        )
        Row{
            Botonera3(calculadora, estadoPantalla)
            BotonesOperacion3(calculadora, estadoPantalla)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculadora3Theme {
        Calculadora("Android")
    }
}