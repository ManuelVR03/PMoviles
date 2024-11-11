package com.example.manuelverdejo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.manuelverdejo.componentes.NavigationButton
import com.example.manuelverdejo.ui.theme.ManuelVerdejoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManuelVerdejoTheme {
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
fun Main(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(vertical = 50.dp)){
        NavigationButton()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ManuelVerdejoTheme {
        Main("Android")
    }
}