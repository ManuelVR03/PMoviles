package com.example.calculadora_mv

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.acivity2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botonAtras:Button = (findViewById<Button>(R.id.buttonAtras))

        botonAtras.setOnClickListener {
            intent= Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

    }



}
