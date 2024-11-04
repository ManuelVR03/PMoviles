package com.example.probandojpc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.probandojpc.ui.theme.ProbandoJPCTheme

class SegundaActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProbandoJPCTheme {
                Actividad2(name = "Android")
            }
        }
    }
}

@Composable
fun Actividad2(name: String){
    val context = LocalContext.current
    Column {
        Text(
            text = "Hola Lucía ^^",
            modifier = Modifier.clickable {
                primeraActividad(context)
            }
        )
    }
}

fun primeraActividad(context: Context) {
    context.startActivity(Intent(context,MainActivity::class.java))
}