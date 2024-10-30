package com.example.calculadora1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora1.ui.theme.Calculadora1Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
fun Botonera(){
    Column {
        Row {
            Button(onClick = {}) {Text(text = "7",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "8",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "9",fontSize = 24.sp)}
        }
        Row {
            Button(onClick = {}) {Text(text = "4",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "5",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "6",fontSize = 24.sp)}
        }
        Row {
            Button(onClick = {}) {Text(text = "1",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "2",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "3",fontSize = 24.sp)}
        }
        Row {
            Button(onClick = {}) {Text(text = "C",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "0",fontSize = 24.sp)}
            Button(onClick = {}) {Text(text = "=",fontSize = 24.sp)}
        }
    }
}

@Composable
fun BotoneraOperaciones(){
    Column {
        Button(onClick = {}) {Text(text = "+", fontSize = 24.sp)}
        Button(onClick = {}) {Text(text = "-", fontSize = 24.sp)}
        Button(onClick = {}) {Text(text = "*", fontSize = 24.sp)}
        Button(onClick = {}) {Text(text = "/", fontSize = 24.sp)}
        Button(onClick = {}) {Text(text = "^2", fontSize = 24.sp)}
        Button(onClick = {}) {Text(text = "sqrt", fontSize = 24.sp)}
    }
}

@Composable
fun Calculadora(name: String, modifier: Modifier = Modifier) {

    var pantalla: String by remember { mutableStateOf("0") }
    var calculadora: Calculadora by remember {mutableStateOf(Calculadora())}

    Column(){
        Text(text = "0.0", fontSize = 24.sp, modifier = Modifier.fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Black))
            .padding(16.dp)
            .padding(top = 50.dp),textAlign = TextAlign.End)

        Row {
            Botonera()
            BotoneraOperaciones()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculadora1Theme {
        Calculadora("Android")
    }
}