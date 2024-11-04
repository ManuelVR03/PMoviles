package com.example.listado_1.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(lista: SnapshotStateList<String>,
               opciones: List<String>,
               seleccion: MutableState<String>,
               nombre: MutableState<String>
){


    Column(modifier = Modifier.padding(16.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            //var text by remember { mutableStateOf("") }
            Column(){
                TextField(
                    value = nombre.value,
                    onValueChange = { newText -> nombre.value = newText },
                    label = { Text("Escribe nombre") },
                    placeholder = { Text("Introduce texto aquí") },
                    modifier = Modifier.fillMaxWidth()
                )
                MiRadioButton(opciones, seleccion)
                Button(
                    onClick = {
                        lista.add(nombre.value+ "  ${seleccion.value}")
                        nombre.value=""
                    }
                ) { Text(text = "Aceptar") } //Al hacer click se guarda ese nombre en el listado
                //Y se muestra en la caja con la lista de nombres

            }
        }

    }





}