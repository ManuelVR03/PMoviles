package com.example.calculadora

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

    var operando1:Double=0.0
    var operando2:Double=0.0
    var operacion:String=""

    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


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

        val botonSuma: Button = findViewById<Button>(R.id.suma)
        botonSuma.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                operacion = "suma"
                operando1 += operando2
                operando2=0.0
                textView.text= ""+operando1

            }
        })

        val botonResta: Button = findViewById<Button>(R.id.resta)
        botonResta.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                operando1 -= operando2
                operacion = "resta"
                operando2=0.0
                textView.text= ""+operando1

            }
        })

        val botonProducto: Button = findViewById<Button>(R.id.producto)
        botonProducto.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                operacion = "producto"
                operando1 *= operando2
                operando2=0.0
                textView.text= ""+operando1

            }
        })

        val botonDivision: Button = findViewById<Button>(R.id.division)
        botonDivision.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                operacion = "division"
                operando1 /= operando2
                operando2=0.0
                textView.text= ""+operando1

            }
        })

        val botonCero: Button = findViewById<Button>(R.id.cero)
        botonCero.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                operando1 = 0.0
                operando2 = 0.0
                operacion=""
                textView.text = "0"
            }
        })

        val botonIgual: Button = findViewById<Button>(R.id.igual)
        botonIgual.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                when (operacion) {
                    "suma" -> operando1 += operando2
                    "resta" -> operando1 -= operando2
                    "producto" -> operando1 *= operando2
                    "division" -> operando1 /= operando2
                }
                if (operacion != ""){
                    operando2=0.0
                    operacion=""
                    textView.text= ""+operando1
                    operando1=0.0
                }
            }
        })
    }

    override fun onClick(p0: View?) {
        val boton = p0 as Button
        val n=(boton.text).toString().toDouble()
        if(operacion==""){
            operando1=(operando1*10)+n
            textView.text= ""+operando1
        }else{
            operando2=(operando2*10)+n
            textView.text= ""+operando2
        }

    }
}