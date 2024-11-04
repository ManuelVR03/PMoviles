package com.example.listado_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listado_1.componentes.Formulario
import com.example.listado_1.componentes.Lista
import com.example.listado_1.ui.theme.Listado_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Listado_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    val personas = remember {mutableStateListOf<String>()}
    var nombre = remember {mutableStateOf<String>("")}
    val opciones= listOf<String>("Hombre", "Mujer")
    var seleccion = remember {mutableStateOf<String>("Hombre")}
    val opciones2= listOf<String>("Inglés B2", "Carnet de conducir")
    val checkedList = remember {mutableStateListOf<Boolean>()}

    //Damos tamaño y valores iniciales a la lista
    checkedList.addAll(List(opciones2.size) { false })



    Column(){
        Formulario(personas,opciones,seleccion,nombre,opciones2,checkedList)
        Lista(personas)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Listado_1Theme {
        Main()
    }
}