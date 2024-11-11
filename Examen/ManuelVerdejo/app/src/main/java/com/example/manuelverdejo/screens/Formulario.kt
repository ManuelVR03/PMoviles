package com.example.manuelverdejo.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.manuelverdejo.componentes.NavigationButton
import com.example.manuelverdejo.modelo.Alimento

class Variables(){
    var grProt by mutableStateOf(0.0)
    var grHC by mutableStateOf(0.0)
    var grLip by mutableStateOf(0.0)
    var cantidad by mutableStateOf(0.0)
}

@Composable
fun Formulario(variables: Variables, nombre: MutableState<String>, alimentos: SnapshotStateList<Alimento>){
    Box(Modifier.padding(vertical = 50.dp)){
        Column {
            NavigationButton()
            Text(text = alimentos[alimentos.size-1].KcalTotales.toString())
            TextField(
                value = nombre.value,
                onValueChange = { newText -> nombre.value = newText },
                label = { Text("Escribe nombre") },
                placeholder = { Text("Introduce texto aquí") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = variables.grProt.toString(),
                onValueChange = { newText -> variables.grProt = newText.toDouble() },
                label = { Text("Escribe grProt") },
                placeholder = { Text("Introduce texto aquí") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = variables.grHC.toString(),
                onValueChange = { newText -> variables.grHC = newText.toDouble() },
                label = { Text("Escribe grHC") },
                placeholder = { Text("Introduce texto aquí") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = variables.grLip.toString(),
                onValueChange = { newText -> variables.grLip = newText.toDouble() },
                label = { Text("Escribe grLip") },
                placeholder = { Text("Introduce texto aquí") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = variables.cantidad.toString(),
                onValueChange = { newText -> variables.cantidad = newText.toDouble() },
                label = { Text("Escribe cantidad") },
                placeholder = { Text("Introduce texto aquí") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {alimentos.add(Alimento(nombre.value, variables.grProt, variables.grHC, variables.grLip, variables.cantidad ))}) {Text(text = "Aceptar") }

        }
    }
}