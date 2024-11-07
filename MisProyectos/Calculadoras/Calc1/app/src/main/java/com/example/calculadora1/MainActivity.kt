package com.example.calculadora1

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
import androidx.compose.runtime.remember as remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora1.ui.theme.Calculadora1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora1Theme {
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
fun Botonera(calculadora: Calculadora, setPantalla: (String) -> Unit) {
    Column {
        Row {
            Button(onClick = { gestionBotones("7", calculadora) { setPantalla("" +calculadora.operando1) } }) {
                Text(
                    text = "7"
                )
            }
            Button(onClick = { gestionBotones("8", calculadora) { setPantalla("8") } }) {
                Text(
                    text = "8"
                )
            }
            Button(onClick = { gestionBotones("9", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "9"
                )
            }
        }
        Row {
            Button(onClick = { gestionBotones("4", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "4"
                )
            }
            Button(onClick = { gestionBotones("5", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "5"
                )
            }
            Button(onClick = { gestionBotones("6", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "6"
                )
            }
        }
        Row {
            Button(onClick = { gestionBotones("1", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "1"
                )
            }
            Button(onClick = { gestionBotones("2", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "2"
                )
            }
            Button(onClick = { gestionBotones("3", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "3"
                )
            }
        }
        Row {
            Button(onClick = {
                calculadora.reset()
                setPantalla("0")
            }) { Text(text = "C") }
            Button(onClick = { gestionBotones("0", calculadora) { setPantalla("" + it) } }) {
                Text(
                    text = "0"
                )
            }
            Button(onClick = { setPantalla(calculadora.resuelveAddOperacion()) }) { Text(text = "=") }
        }
    }
}

@Composable
fun BotoneraOperaciones(calculadora: Calculadora, setPantalla: (String) -> Unit) {
    Column {
        Button(onClick = { setPantalla(calculadora.resuelveAddOperacion("suma")) }) { Text(text = "+") }
        Button(onClick = { setPantalla(calculadora.resuelveAddOperacion("resta")) }) { Text(text = "-") }
        Button(onClick = { setPantalla(calculadora.resuelveAddOperacion("multiplica")) }) {
            Text(
                text = "*"
            )
        }
        Button(onClick = { setPantalla(calculadora.resuelveAddOperacion("divide")) }) { Text(text = "/") }
        Button(onClick = { setPantalla(calculadora.resuelveAddOperacion("cuadrado")) }) { Text(text = "^2") }
        Button(onClick = { setPantalla(calculadora.resuelveAddOperacion("raizCuadrada")) }) {
            Text(
                text = "sqrt"
            )
        }
    }
}

@Composable
fun Calculadora(name: String, modifier: Modifier = Modifier) {

    var calculadora: Calculadora by remember { mutableStateOf(Calculadora()) }
    var pantalla: String by remember { mutableStateOf("0") }

    Column {
        Text(
            text = pantalla,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black))
                .padding(16.dp)
                .padding(top = 50.dp), textAlign = TextAlign.End
        )
        Row {
            Botonera(calculadora, { nuevaPantalla -> pantalla = nuevaPantalla })
            BotoneraOperaciones(calculadora, { nuevaPantalla -> pantalla = nuevaPantalla })
        }

    }

}

fun gestionBotones(numBoton: String, calculadora: Calculadora, cambiaValor: (Double) -> Unit) {

    var numPantalla = numBoton.toDouble()
    if (calculadora.operacion == "") {
        calculadora.operando1 = (calculadora.operando1 * 10) + numPantalla
        cambiaValor(calculadora.operando1)

    } else {
        calculadora.operando2 = (calculadora.operando2 * 10) + numPantalla
        cambiaValor(calculadora.operando2)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculadora1Theme {
        Calculadora("Android")
    }
}