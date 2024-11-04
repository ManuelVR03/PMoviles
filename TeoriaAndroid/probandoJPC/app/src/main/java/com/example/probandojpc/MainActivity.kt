package com.example.probandojpc


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
    var texto1 by remember { mutableStateOf("Alguien te quiere conocer") }
    Column(){
        Text(
            text = texto1,
            modifier=Modifier.clickable {
                segundaActividad(context)
            }
        )

        Button(onClick={
            texto1="Manuel quiere darte un abrazo"
        }){
            Text(text = "Revelar")
        }

    }

}

fun segundaActividad(context: Context) {
    context.startActivity(Intent(context,SegundaActivity::class.java))
}

@Preview(name ="Mi primera preview", showBackground = true )
@Composable
fun GreetingPreview() {
    ProbandoJPCTheme {
        Main("Android")
    }
}