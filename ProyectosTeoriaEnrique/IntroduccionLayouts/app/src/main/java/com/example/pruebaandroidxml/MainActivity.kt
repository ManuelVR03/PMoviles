package com.example.pruebaandroidxml

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val textView= findViewById<TextView>(R.id.textView)
        textView.text= "hola que pasa"


        val boton1: Button = findViewById<Button>(R.id.button)
        boton1.text="PULSAR 1"
        boton1.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view:View?){
                textView.text= "Botón 1 pulsado"
                boton1.text="He sido pulsado"
            }
        })

        val boton2: Button= findViewById<Button>(R.id.button2)
        boton2.text="PULSAR 2"
        boton2.setOnClickListener{
            textView.text= "Botón 2 pulsado"
            boton2.text="Se pulsó 2"
        }

        val boton3=findViewById<Button>(R.id.button3)
        boton3.text="este es el boton 3"
        boton3.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view:View?){
                textView.text= "Botón 3 pulsado"
                boton1.text="He sido pulsado"
            }
        })

        Log.i("mensaje", "hola*****************")
        System.out.println("mensaje")

    }
}