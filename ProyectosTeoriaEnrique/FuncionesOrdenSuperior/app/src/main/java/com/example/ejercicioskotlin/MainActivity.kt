package com.example.ejercicioskotlin
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        text =findViewById<TextView>(R.id.textView)

        //Implementa su propio interfaz OnClickListener de función anónima
        val boton1 = (findViewById<Button>(R.id.button1)).setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                text.text ="Se ha pulsado el botón 1"
            }
        })

        //Usa como Listener al propio Activity el cual implementa OnClickListener
        val boton2 = (findViewById<Button>(R.id.button2)).setOnClickListener (this)

        // La función anónima ahora se pasa en forma de función Lambda a una función de
        // orden superior llamada  setOnClickListener que ya está definida en el propio Button
        val boton3 = (findViewById<Button>(R.id.button3)).setOnClickListener {
            text.text="Se ha pulsado el botón 3"
        }

        // Para ver el mecanismo completo usamos la misma técnica, es decir
        // Creamos la función de orden superior pero en el propio Activity
        val boton4 = (findViewById<Button>(R.id.button4))
        gestionarClick(boton4){
            text.text="Se ha pulsado el botón 4"
        }

        //Aunque no es necesario porque ya está hecho, creamos también una función de
        //orden superior pero en el propio Button. Como la clase Button ya está hecha
        //y cerrada, hacemos uso de las funciones extensibles de Kotlin para añadir
        //una nueva función
        fun Button.hacerClick( fn: (View)->Unit){
            this.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                  fn(view)
                }
            })
        }
        val boton5 = (findViewById<Button>(R.id.button5)).hacerClick {
            text.text="Se ha pulsado el botón 5"
        }
    }

    // Función de orden superior definida en el propio Activity se le pasa como
    //argumento el objeto que genera el evento y una funcion anónima (lambda)
    //que será la encargada de realizar la gestión del evento
    fun gestionarClick(v:View, fn:(View)->Unit){
        v.setOnClickListener{
            fn(v)
        }
    }

    override fun onClick(p0: View?) {

        text.text="Se ha pulsado el botón 2"

    }

}