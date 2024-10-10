package com.example.calculadora_mv


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    //Logica de negocio. Hay que intentar siempre sacarla fuera de la vista
    lateinit var calculadora:Calculadora

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        calculadora=Calculadora()
        textView = findViewById<TextView>(R.id.textView)

        val boton0 = (findViewById<Button>(R.id.button0)).setOnClickListener { gestionarClick(it) }
        val boton1 = (findViewById<Button>(R.id.button1)).setOnClickListener { gestionarClick(it) }
        val boton2 = (findViewById<Button>(R.id.button2)).setOnClickListener { gestionarClick(it) }
        val boton3 = (findViewById<Button>(R.id.button3)).setOnClickListener { gestionarClick(it) }
        val boton4 = (findViewById<Button>(R.id.button4)).setOnClickListener { gestionarClick(it) }
        val boton5 = (findViewById<Button>(R.id.button5)).setOnClickListener { gestionarClick(it) }
        val boton6 = (findViewById<Button>(R.id.button6)).setOnClickListener { gestionarClick(it) }
        val boton7 = (findViewById<Button>(R.id.button7)).setOnClickListener { gestionarClick(it) }
        val boton8 = (findViewById<Button>(R.id.button8)).setOnClickListener { gestionarClick(it) }
        val boton9 = (findViewById<Button>(R.id.button9)).setOnClickListener { gestionarClick(it) }

        //Los botones de operaciones, CE e igual, gestionan sus propios eventos
        val botonSuma= (findViewById<Button>(R.id.suma)).setOnClickListener { gestionarClick(it) }
        val botonResta=(findViewById<Button>(R.id.resta)).setOnClickListener { gestionarClick(it) }
        val botonDivide=(findViewById<Button>(R.id.divide)).setOnClickListener { gestionarClick(it) }
        val botonMultiplica=(findViewById<Button>(R.id.multiplica)).setOnClickListener { gestionarClick(it) }
        val botonCuadrado=(findViewById<Button>(R.id.cuadrado)).setOnClickListener { gestionarClick(it) }
        val botonRaizCuadrada=(findViewById<Button>(R.id.raizcuadrada)).setOnClickListener { gestionarClick(it) }
        val botonIgual=(findViewById<Button>(R.id.igual)).setOnClickListener { gestionarClick(it) }
        val botonCero=(findViewById<Button>(R.id.cero)).setOnClickListener { gestionarClick(it) }
        //resto de operaciones

        //Botón a nueva Activity
        val botonPantalla2=(findViewById<Button>(R.id.buttonPantalla2)).setOnClickListener {

            intent=Intent (this, Activity2::class.java)
            startActivity(intent)

        }


    }
    private fun gestionarClick(view:View){
        val boton= view as Button
        val texto=boton.text.toString()
        when(texto){
            "0","1","2","3","4","5","6","7","8","9" -> procesarNumero(texto)
            "+","-","X","/","^2","Raíz cuadrada" -> procesarOperacion(texto)
            "=" -> textView.text = calculadora.resuelveAddOperacion()
            "C" -> { calculadora.reset()
                    textView.text = "0"}
          }
    }

    private fun procesarOperacion(texto: String) {
        textView.text = calculadora.resuelveAddOperacion(texto)
    }
    private fun procesarNumero(texto: String) {
        val n = texto.toDouble()
        if (calculadora.operacion == "") {
            calculadora.operando1 = (calculadora.operando1 * 10) + n
            textView.text = "" + calculadora.operando1
        } else {
            calculadora.operando2 = (calculadora.operando2 * 10) + n
            textView.text = "" + calculadora.operando2
        }
    }


}