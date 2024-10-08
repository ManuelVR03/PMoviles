package com.example.calculadora_mv

class Calculadora {

    var operando1: Double = 0.0
    var operando2: Double = 0.0
    var operacion: String = ""

    fun resuelveAddOperacion(op:String=""):Double{
        when (operacion) {
            "suma" -> operando1 += operando2
            "resta" -> operando1 -= operando2
        }
        operacion=op
        operando2=0.0
        return operando1
    }

    fun reset(){
        operando1 = 0.0
        operando2 = 0.0
        operacion = ""
    }

}