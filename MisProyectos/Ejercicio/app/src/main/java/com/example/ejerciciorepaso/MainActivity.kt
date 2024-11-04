package com.example.ejerciciorepaso

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejerciciorepaso.ui.theme.EjercicioRepasoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicioRepasoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Formulario(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Formulario(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(text = "Introduce un nombre: ")
        Text(text = "Sexo: ")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjercicioRepasoTheme {
        Formulario("Android")
    }
}