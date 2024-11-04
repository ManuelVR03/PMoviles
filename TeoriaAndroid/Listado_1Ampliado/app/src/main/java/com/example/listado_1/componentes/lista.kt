package com.example.listado_1.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import com.example.listado_1.modelo.Persona

@Composable
fun Lista(listado: SnapshotStateList<Persona>){
    Box(){
        Column(){
            Text(text="Listado de nombres")
            listado.forEachIndexed{ i, persona->
                Text(text=persona.nombre + " " + persona.sexo)
                Text(text="Inglés -> " + persona.inglesB2)
                Text(text="Carnet -> " + persona.carnetB1)
            }

        }

    }
}