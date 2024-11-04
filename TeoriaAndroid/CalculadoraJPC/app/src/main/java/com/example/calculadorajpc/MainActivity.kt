package com.example.calculadorajpc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadorajpc.ui.theme.CalculadoraJPCTheme
import androidx.compose.runtime.remember as remember

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraJPCTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculadora(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun Botonera(calculadora:Calculadora, setPantalla:(String)->Unit){
    Column( modifier = Modifier.padding(16.dp)){
        Row(){
            Button(onClick = {gestionBotones("1", calculadora){
                setPantalla(""+it)
            } }){Text(text = "1",fontSize = 24.sp)}
            Button(onClick = {gestionBotones("2", calculadora){
                setPantalla(""+it)
            } }){Text(text = "2",fontSize = 24.sp)}
            Button(onClick = {gestionBotones("3", calculadora){
                setPantalla(""+it)
            } }){Text(text = "3",fontSize = 24.sp)}
        }
        Row(){
            Button(onClick = {gestionBotones("4", calculadora){
                setPantalla(""+it)
            } }){Text(text = "4",fontSize = 24.sp)}
            Button(onClick = {gestionBotones("5", calculadora){
                setPantalla(""+it)
            } }){Text(text = "5",fontSize = 24.sp)}
            Button(onClick = {gestionBotones("6", calculadora){
                setPantalla(""+it)
            } }){Text(text = "6",fontSize = 24.sp)}        }
        Row(){
            Button(onClick = {gestionBotones("7", calculadora){
                setPantalla(""+it)
            } }){Text(text = "7",fontSize = 24.sp)}
            Button(onClick = {gestionBotones("8", calculadora){
                setPantalla(""+it)
            } }){Text(text = "8",fontSize = 24.sp)}
            Button(onClick = {gestionBotones("9", calculadora){
                setPantalla(""+it)
            } }){Text(text = "9",fontSize = 24.sp)}        }
        Row(){
            Button(onClick = {
                calculadora.reset()
                setPantalla("0")
            } ){Text(text = "C",fontSize = 24.sp)}

            Button(onClick = {gestionBotones("0", calculadora){
                setPantalla(""+it)
            } }){Text(text = "0",fontSize = 24.sp)}
            Button(onClick = {
                setPantalla(""+calculadora.resuelveAddOperacion())
            }){Text(text = "=",fontSize = 24.sp)}        }
    }

}
@Composable
fun Botonera2(calculadora:Calculadora, setPantalla:(String)->Unit) {
    val n= listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    var id=0
    Column() {
        for (i in 1..3){
            Row(){
                for (j in 1..3) {
                    val s=n[id]
                    Button(onClick = {
                        gestionBotones(s, calculadora){
                        setPantalla(""+it)
                    } }){Text(text = s,fontSize = 24.sp)}
                    id++
                }

            }
        }
        Row(){
            Button(onClick = {
                calculadora.reset()
                setPantalla("0")
            } ){Text(text = "C",fontSize = 24.sp)}

            Button(onClick = {gestionBotones("0", calculadora){
                setPantalla(""+it)
            } }){Text(text = "0",fontSize = 24.sp)}
            Button(onClick = {
                setPantalla(""+calculadora.resuelveAddOperacion())
            }){Text(text = "=",fontSize = 24.sp)}        }

    }
}
@Composable
fun Botonera3(calculadora:Calculadora,  estadoPantalla:EstadoPantalla) {
    val n= listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    var id=0
    Column() {
        for (i in 1..3){
            Row(){
                for (j in 1..3) {
                    val s=n[id]
                    Button(onClick = {
                        Log.d("cal",s)
                        gestionBotonesRef(s, calculadora, estadoPantalla) }){Text(text = s,fontSize = 24.sp)}
                    id++
                }

            }
        }
        Row(){
            Button(onClick = {
                calculadora.reset()
                estadoPantalla.pantalla="0"
            } ){Text(text = "C",fontSize = 24.sp)}

            Button(onClick = {gestionBotonesRef("0", calculadora, estadoPantalla)}){Text(text = "0",fontSize = 24.sp)}
            Button(onClick = {
                estadoPantalla.pantalla=""+calculadora.resuelveAddOperacion()


            }){Text(text = "=",fontSize = 24.sp)}        }

    }
}



@Composable
fun BotonesOperaciones(calculadora:Calculadora, setPantalla:(String)->Unit){
    Column( modifier = Modifier.padding(16.dp)){
        Button(onClick = {setPantalla(calculadora.resuelveAddOperacion("suma"))} ){Text(text = "+",fontSize = 24.sp)}
        Button(onClick = {setPantalla(calculadora.resuelveAddOperacion("resta"))}){Text(text = "-",fontSize = 24.sp)}
        Button(onClick = {setPantalla(calculadora.resuelveAddOperacion("multiplica"))}){Text(text = "x",fontSize = 24.sp)}
        Button(onClick = {setPantalla(calculadora.resuelveAddOperacion("divide"))}){Text(text = "/",fontSize = 24.sp)}
        Button(onClick = {setPantalla(calculadora.resuelveAddOperacion("cuadrado"))}){Text(text = "^2",fontSize = 24.sp)}
        Button(onClick = {setPantalla(calculadora.resuelveAddOperacion("raizCuadrada"))}){Text(text = "Raíz",fontSize = 24.sp)}
    }
}
@Composable
fun BotonesOperaciones2(calculadora: Calculadora, setPantalla: (String) -> Unit) {
    val operaciones = listOf("+" to "suma", "-" to "resta", "x" to "multiplica", "/" to "divide", "^2" to "cuadrado", "Raíz" to "raizCuadrada")

    Column(modifier = Modifier.padding(16.dp)) {
        operaciones.forEach { (simbolo, operacion) ->
            Button(onClick = { setPantalla(calculadora.resuelveAddOperacion(operacion)) }) {
                Text(text = simbolo, fontSize = 24.sp)
            }

        }
    }
}

fun gestionBotones( s: String, calculadora:Calculadora, cambiaValor:(Double)->Unit) {

    var n = s.toDouble()
    if (calculadora.operacion == "") {
        calculadora.operando1 = (calculadora.operando1 * 10) + n
        cambiaValor(calculadora.operando1)

    } else {
        calculadora.operando2 = (calculadora.operando2 * 10) + n
        cambiaValor(calculadora.operando2)
    }
}


@Composable
fun BotonesOperaciones3(calculadora: Calculadora, estadoPantalla:EstadoPantalla) {
    val operaciones = listOf("+" to "suma", "-" to "resta", "x" to "multiplica", "/" to "divide", "^2" to "cuadrado", "Raíz" to "raizCuadrada")

    Column(modifier = Modifier.padding(16.dp)) {
        operaciones.forEach { (simbolo, operacion) ->
            Button(onClick = { estadoPantalla.pantalla=""+calculadora.resuelveAddOperacion(operacion) }) {
                Text(text = simbolo, fontSize = 24.sp)
            }

        }
    }
}
fun gestionBotonesRef( s: String, calculadora:Calculadora, estadoPantalla:EstadoPantalla) {

    var n = s.toDouble()
    if (calculadora.operacion == "") {
        calculadora.operando1 = (calculadora.operando1 * 10) + n
        estadoPantalla.pantalla=""+calculadora.operando1

    } else {
        calculadora.operando2 = (calculadora.operando2 * 10) + n
        estadoPantalla.pantalla=""+calculadora.operando2
    }
}
class EstadoPantalla() {
    var pantalla by mutableStateOf("0")
}

@Composable
fun Calculadora(name: String,modifier: Modifier = Modifier) {

    var calculadora:Calculadora by remember{mutableStateOf(Calculadora())}
    var pantalla:String by remember{mutableStateOf("0")}
// otra opcion al ser un objeto se podria haber pasado a las funciones por referencia
    var estadoPantalla = remember {EstadoPantalla() }

    Column(){
        Text(text = estadoPantalla.pantalla,fontSize = 24.sp,modifier = Modifier.fillMaxWidth()
                .border(BorderStroke(1.dp, Color.Black))
                .padding(16.dp)
                .padding(top = 50.dp),textAlign = TextAlign.End)
        Row(){
            //Botonera2(calculadora) { nuevaPantalla -> pantalla = nuevaPantalla }
            //BotonesOperaciones2(calculadora) { nuevaPantalla -> pantalla = nuevaPantalla }
            Botonera3(calculadora, estadoPantalla)
            BotonesOperaciones3(calculadora,estadoPantalla)


        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraJPCTheme {

    }
}