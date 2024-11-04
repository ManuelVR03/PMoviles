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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.os.persistableBundleOf
import com.example.listado_1.modelo.Persona

@Composable
fun Formulario(lista: SnapshotStateList<Persona>,
               opciones: List<String>,
               seleccion: MutableState<String>,
               nombre: MutableState<String>,
               opciones2: List<String>,
               checkedList: SnapshotStateList<Boolean>
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
                MiCheckBox(opciones2,checkedList)
                Button(
                    onClick = {
                        lista.add(Persona(nombre.value, seleccion.value, checkedList[0], checkedList[1]))
                        nombre.value=""
                    }
                ) { Text(text = "Aceptar") } //Al hacer click se guarda ese nombre en el listado
                //Y se muestra en la caja con la lista de nombres

            }
        }

    }





}