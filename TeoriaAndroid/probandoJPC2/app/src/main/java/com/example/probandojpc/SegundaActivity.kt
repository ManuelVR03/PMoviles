package com.example.probandojpc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.probandojpc.ui.theme.ProbandoJPCTheme

class SegundaActivity : ComponentActivity()  {

    lateinit var textView1:TextView
    lateinit var textView2:TextView
    lateinit var textView3:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textView1 = findViewById<TextView>(R.id.textView)
        textView2 = findViewById<TextView>(R.id.textView2)
        textView3 = findViewById<TextView>(R.id.textView3)


        val boton: Button = findViewById<Button>(R.id.button)
        boton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView1.text = "Se ha pulsado el boton 1"
                textView2.text = "Se ha pulsado el boton 1"
                textView3.text = "Se ha pulsado el boton 1"



            }
        })
    }
}