package com.example.manuelverdejo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.manuelverdejo.modelo.Alimento

@Composable
fun Listado(alimentos: SnapshotStateList<Alimento>){
    Box(Modifier.padding(vertical = 50.dp)){
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Listado: ")
            alimentos.forEach{
                Text(text = "Nombre: " + it.nombre + " Cantidad: " + it.cantidad + " KCal: " + it.KcalTotales, Modifier.clickable {})
            }

        }
    }
}

