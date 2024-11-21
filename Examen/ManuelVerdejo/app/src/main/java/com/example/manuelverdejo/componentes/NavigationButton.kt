package com.example.manuelverdejo.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.manuelverdejo.modelo.Alimento
import com.example.manuelverdejo.screens.*


@Composable
fun NavigationButton(){
    val variables = remember {Variables()}
    val nombre = remember { mutableStateOf("") }
    val alimentos = remember { mutableStateListOf<Alimento>() }
    Row{
        Button(onClick = {ActividadPrincipal()}) { Text(text = "Principal")
            }
        Button(onClick = {ActividadFormulario(variables, nombre, alimentos)}) {Text(text = "Formulario")
            }
        Button(onClick = {ActividadListado(alimentos)}) { Text(text = "Listado")
            }
    }
}
@Composable
fun ActividadPrincipal(){
    Principal()
}

@Composable
fun ActividadFormulario(variables: Variables, nombre: MutableState<String>, alimentos: SnapshotStateList<Alimento>){
    Formulario(variables, nombre, alimentos)
}

@Composable
fun ActividadListado(alimentos: SnapshotStateList<Alimento>){
    Listado(alimentos)
}

