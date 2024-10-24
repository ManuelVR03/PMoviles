package com.example.calculadorajpc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
fun Main(name: String, modifier: Modifier = Modifier){
    val context = LocalContext.current

    var texto1 = "0.0"

    Column() {


            Text(
                text = texto1,
                modifier = Modifier
                    .clickable { hacerClickBoton() }
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, Color.Black)) // Añadimos un borde
                    .padding(16.dp),
                textAlign = TextAlign.End
            )


        Row() {
            Button(onClick = {hacerClickBoton() }) { Text(text = "1")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "2")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "3")}
        }
        Row() {
            Button(onClick = {hacerClickBoton() }) { Text(text = "4")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "5")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "6")}
        }
        Row() {
            Button(onClick = {hacerClickBoton() }) { Text(text = "7")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "8")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "9")}
        }
        Row() {
            Button(onClick = {hacerClickBoton() }) { Text(text = "C")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "0")}
            Button(onClick = {hacerClickBoton() }) { Text(text = "=")}
        }
    }

}

fun hacerClickBoton(){}

