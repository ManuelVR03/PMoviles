package com.example.calculadora_mv

import kotlin.math.sqrt

class Calculadora {

    var operando1: Double = 0.0
    var operando2: Double = 0.0
    var operacion: String = ""
    fun resuelveAddOperacion(op:String=""):String{
                //Para el caso de operaciones con un solo operando. Realiza la operación inmediatamente
                when (op) {
                    "^2"->{
                        return if(operacion=="") {
                            operando1 *= operando1
                            "" + operando1
                            }
                            else {
                            operando2 *= operando2
                            "" + operando2
                        }
                    }
                    "Raíz cuadrada"-> {
                        return if(operacion==""){
                                val resultado=calculaRaizCuadrada(operando1)
                                operando1=resultado.toDoubleOrNull()?:operando1
                                ""+resultado
                            }else {
                                val resultado=calculaRaizCuadrada(operando2)
                                operando2=resultado.toDoubleOrNull()?:operando2
                                ""+resultado
                            }
                       }
                }
                when (operacion) {
                    "+" ->operando1 += operando2
                    "-" ->operando1 -= operando2
                    "/" -> {
                        if(operando2==0.0) {
                           reset()
                           return "ERROR DIVISIÓN POR CERO"
                        }else operando1 /= operando2
                    }
                    "X" ->operando1 *= operando2
                }
                operando2=0.0
                operacion=op

        return ""+operando1
    }
    fun calculaRaizCuadrada(n:Double):String{
        return if(n<0.0){
            reset()
            "ERROR: RAÍZ NEGATIVA"
        }
            else ""+sqrt(n)
    }
    fun reset(){
        operando1 = 0.0
        operando2 = 0.0
        operacion = ""
    }

}