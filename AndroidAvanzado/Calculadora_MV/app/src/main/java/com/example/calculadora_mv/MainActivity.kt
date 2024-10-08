package com.example.calculadora_mv


import android.annotation.SuppressLint
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

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var textView: TextView

    //Logica de negocio. Hay que intentar siempre sacarla fuera de la vista
    lateinit var calculadora:Calculadora

    @SuppressLint("MissingInflatedId")
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

        val boton0 = (findViewById<Button>(R.id.button0)).setOnClickListener(this)
        val boton1 = (findViewById<Button>(R.id.button1)).setOnClickListener(this)
        val boton2 = (findViewById<Button>(R.id.button2)).setOnClickListener(this)
        val boton3 = (findViewById<Button>(R.id.button3)).setOnClickListener(this)
        val boton4 = (findViewById<Button>(R.id.button4)).setOnClickListener(this)
        val boton5 = (findViewById<Button>(R.id.button5)).setOnClickListener(this)
        val boton6 = (findViewById<Button>(R.id.button6)).setOnClickListener(this)
        val boton7 = (findViewById<Button>(R.id.button7)).setOnClickListener(this)
        val boton8 = (findViewById<Button>(R.id.button8)).setOnClickListener(this)
        val boton9 = (findViewById<Button>(R.id.button9)).setOnClickListener(this)

        //Resto de botones


        //Los botones de operaciones, CE e igual, gestionan sus propios eventos
        val botonSuma: Button = findViewById<Button>(R.id.suma)
        botonSuma.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView.text = "" + calculadora.resuelveAddOperacion("suma")
            }
        })
        val botonResta: Button = findViewById<Button>(R.id.resta)
        botonResta.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView.text = "" + calculadora.resuelveAddOperacion("resta")
            }
        })
        val botonCero: Button = findViewById<Button>(R.id.cero)
        botonCero.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView.text = ""+calculadora.reset()
            }
        })
        val botonGrados: Button = findViewById<Button>(R.id.grados)
        botonCero.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView.text = textView.text.toString() + "ª "
            }
        })
        val botonMinutos: Button = findViewById<Button>(R.id.minutos)
        botonCero.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView.text = textView.text.toString() + "'"
            }
        })
        val botonIgual: Button = findViewById<Button>(R.id.igual)
        botonIgual.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textView.text = "" + calculadora.resuelveAddOperacion()
            }
        })

        //resto de operaciones
    }

    //La ventana gestiona el teclado numérico
    override fun onClick(p0: View?) {
        val boton = p0 as Button
        val n = (boton.text).toString().toDouble()
        if (calculadora.operacion == "") {
            calculadora.operando1 = (calculadora.operando1 * 10) + n
            textView.text = "" + calculadora.operando1
        } else {
            calculadora.operando2 = (calculadora.operando2 * 10) + n
            textView.text = "" + calculadora.operando2
        }
    }

}