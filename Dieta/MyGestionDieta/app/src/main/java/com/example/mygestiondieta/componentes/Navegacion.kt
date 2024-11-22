package com.example.mygestiondieta.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BotonesCambio(pantalla: MutableState<Int>){
    Row(modifier = Modifier.padding(top = 35.dp)) {
        Button(onClick = {pantalla.value = 1}) {Text("Carrito")}
        Button(onClick = {pantalla.value = 2}) {Text("Lista") }
    }
}