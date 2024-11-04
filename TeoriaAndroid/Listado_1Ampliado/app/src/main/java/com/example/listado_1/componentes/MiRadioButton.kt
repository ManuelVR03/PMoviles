package com.example.listado_1.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MiRadioButton(opciones:List<String>,
                  seleccion: MutableState<String>) {
    Column {
        Text("Selecciona una opción:")

        for (texto in opciones) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
                    .clickable {
                        seleccion.value = texto
                    } // Cambia al hacer clic en el texto o el RadioButton
            ) {
                RadioButton(
                    selected = seleccion.value == texto,
                    onClick = { seleccion.value = texto} // Cambia al hacer clic en el RadioButton
                )
                Text(texto)
            }
        }
    }

}