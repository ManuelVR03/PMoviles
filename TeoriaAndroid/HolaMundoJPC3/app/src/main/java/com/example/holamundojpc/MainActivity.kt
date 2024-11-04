package com.example.holamundojpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.holamundojpc.ui.theme.HolaMundoJPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaMundoJPCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun Teclado(modifier: Modifier = Modifier) {
    var persona by remember {mutableStateOf(Persona())}

    var suma by remember {mutableStateOf(0)}
    var mensaje by remember {mutableStateOf("")}
    Column(modifier) {


        BotonNumerico(1,pulsado={suma+=1})
        BotonNumerico(2,pulsado={suma+=2})
        BotonNumerico(3,pulsado={suma+=3})
        BotonNumerico(4,pulsado={suma+=4})


        (1..4).forEach { num ->
            Button(onClick = { suma += num }) {
                Text(text = num.toString())
            }
        }

        Button(onClick = { mensaje=gestorTeclado(1)}) {
            Text(text =mensaje)
        }
        Button(onClick = { mensaje=gestorTeclado(2)}) {
            Text(text ="Botón 2")
        }

        Text(text="La suma vale ${suma} ")
        Text(text="el mensaje es: ${mensaje} ")

    }
}


fun gestorTeclado(id: Int):String{

    return when (id) {
        1 -> "boton 1"
        2 -> "boton 2"

        else -> "No pulsado"
    }
}




@Composable
fun BotonNumerico(num:Int, pulsado:()->Unit){

    Button(onClick={
        pulsado()
    }){
        Text(num.toString())
    }


}



@Composable
    fun Main(name: String, modifier: Modifier = Modifier) {

        Teclado(modifier)


    }
