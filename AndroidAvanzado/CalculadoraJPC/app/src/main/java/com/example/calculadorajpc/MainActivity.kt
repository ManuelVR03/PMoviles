package com.example.calculadorajpc

import android.os.Bundle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.calculadorajpc.ui.theme.CalculadoraJPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraJPCTheme {
                Main(name = "Android")
            }
        }
    }

}

@Composable
fun Main(name: String, modifier: Modifier = Modifier) {
    var calculadora = Calculadora()
    var texto1 by remember { mutableStateOf("0.0") }

    Column {
        Text(
            text = texto1,
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black))
                .padding(16.dp),
            textAlign = TextAlign.End
        )

        // Filas de botones
        Row { listOf("1", "2", "3", "+", "*").forEach { CrearBoton(it) { texto1 = gestionarClick(it, calculadora, texto1) } } }
        Row { listOf("4", "5", "6", "-", "/").forEach { CrearBoton(it) { texto1 = gestionarClick(it, calculadora, texto1) } } }
        Row { listOf("7", "8", "9", "sqrt", "^2").forEach { CrearBoton(it) { texto1 = gestionarClick(it, calculadora, texto1) } } }
        Row { listOf("C", "0", "=").forEach { CrearBoton(it) { texto1 = gestionarClick(it, calculadora, texto1) } } }
    }
}

@Composable
fun CrearBoton(texto: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(4.dp)) {
        Text(text = texto)
    }
}

private fun gestionarClick(texto: String, calculadora: Calculadora, texto1: String): String {
    return when (texto) {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> procesarNumero(texto, calculadora)
        "+", "-", "X", "/", "^2", "sqrt" -> calculadora.resuelveAddOperacion(texto)
        "=" -> calculadora.resuelveAddOperacion()
        "C" -> {
            calculadora.reset()
            "0"
        }
        else -> texto1
    }
}

private fun procesarNumero(texto: String, calculadora: Calculadora): String {
    val n = texto.toDouble()
    return if (calculadora.operacion == "") {
        calculadora.operando1 = (calculadora.operando1 * 10) + n
        "" + calculadora.operando1
    } else {
        calculadora.operando2 = (calculadora.operando2 * 10) + n
        "" + calculadora.operando2
    }
}

