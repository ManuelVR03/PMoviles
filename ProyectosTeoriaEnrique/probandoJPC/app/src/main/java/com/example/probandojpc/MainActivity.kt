package com.example.probandojpc


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.probandojpc.ui.theme.ProbandoJPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProbandoJPCTheme {
               Main(name = "Android")
            }
        }
    }

}




@Composable
fun Main(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    //var texto1 by remember { mutableStateOf("hola") }

    var texto1 = remember { mutableStateOf("No se ha pulsado el botón") }



    //var texto1 by rememberSaveable { mutableStateOf("hola") }

    var mensajes = remember {
        mutableStateListOf(
            "etiqueta1",
            "etiqueta2",
            "etiqueta3",
            "etiqueta4",
            "etiqueta5"
        )
    }

    Column() {

        mensajes.forEachIndexed { i, text ->
            Text(
                text = text,
                modifier = Modifier
                        .clickable { hacerClickText(i, mensajes) }
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, Color.Black)) // Añadimos un borde
                        .padding(16.dp),
                textAlign = TextAlign.End
            )
        }

        Row() {
                Button(onClick = {
                    repeat(5){
                        mensajes[it]="Se ha pulsado el botón 1"
                    }

                }) { Text(text = "Mostrar texto") }

                Button(onClick = { segundaActividad(context) }
                ) { Text(text = "Ir a segundo Activity") }

        }
    }
}

fun hacerClickText(id: Int, textos:MutableList<String>) {
    when(id){
        0-> textos[id]="hola1"
        1-> textos[id]="hola2"
        2-> textos[id]="hola3"
        3-> textos[id]="hola4"
        4-> textos[id]="hola5"
    }
}

fun segundaActividad(context: Context) {
    context.startActivity(Intent(context, SegundaActivity::class.java))
}
