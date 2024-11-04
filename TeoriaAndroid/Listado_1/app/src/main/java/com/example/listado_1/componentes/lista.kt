package com.example.listado_1.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier

@Composable
fun Lista(listado: SnapshotStateList<String>){
    Box(){
        Column(){
            Text(text="Listado de nombres")
            listado.forEachIndexed{ i, nombre->
                Text(text=nombre,
                    Modifier.clickable {
                        listado.removeAt(i)
                    }
                )
            }

        }

    }
}