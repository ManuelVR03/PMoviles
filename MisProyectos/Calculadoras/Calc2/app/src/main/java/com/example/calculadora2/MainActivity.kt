package com.example.calculadora2

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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember as remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora2.ui.theme.Calculadora2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora2Theme {
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
fun Botonera2(calculadora: Calculadora, pantalla: MutableState<String>){

    val numeros = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    var id = 0
    Column{
        for(i in 1..3){
            Row {
                for(j in 1..3){
                    var num = numeros[id]
                    Button(onClick = {gestionBotones(num, calculadora, pantalla)})
                    { Text(text = num) }
                    id++
                }
            }
        }
        Row {
            Button(onClick = {calculadora.reset()
                pantalla.value = "0"}) { Text(text = "C") }
            Button(onClick = { gestionBotones("0", calculadora, pantalla)})
            {Text(text = "0")}
            Button(onClick = {pantalla.value = ""+calculadora.resuelveAddOperacion()})
            { Text(text = "=") }

        }
    }
}

@Composable
fun BotonesOperaciones2(calculadora: Calculadora, pantalla: MutableState<String>){
    var operaciones = listOf("+" to "suma", "-" to "resta", "*" to "multiplica", "/" to "divide", "^2" to "cuadrado", "sqrt" to "raizCuadrada")
    Column {
        operaciones.forEach{ (simbolo, operacion) ->
            Button(onClick = {pantalla.value = calculadora.resuelveAddOperacion(operacion)}) {
                Text(
                    text = simbolo
                )
            }
        }
    }
}

fun gestionBotones( s: String, calculadora:Calculadora, pantalla: MutableState<String>) {

    var n = s.toDouble()
    if (calculadora.operacion == "") {
        calculadora.operando1 = (calculadora.operando1 * 10) + n
        pantalla.value=""+calculadora.operando1

    } else {
        calculadora.operando2 = (calculadora.operando2 * 10) + n
        pantalla.value=""+calculadora.operando2
    }
}

@Composable
fun Calculadora(name: String, modifier: Modifier = Modifier) {

    var calculadora: Calculadora by remember {mutableStateOf(Calculadora())}
    var pantalla = remember { mutableStateOf("0") }

    Column{
        Text(
            text = pantalla.value,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black))
                .padding(16.dp)
                .padding(top = 50.dp),textAlign = TextAlign.End
        )
        Row {
            Botonera2(calculadora, pantalla)
            BotonesOperaciones2(calculadora, pantalla)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculadora2Theme {
        Calculadora("Android")
    }
}