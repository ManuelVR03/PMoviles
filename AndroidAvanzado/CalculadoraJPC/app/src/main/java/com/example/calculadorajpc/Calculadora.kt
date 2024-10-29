// Calculadora.kt
package com.example.calculadorajpc

import kotlin.math.sqrt

class Calculadora {

    var operando1: Double = 0.0
    var operando2: Double = 0.0
    var operacion: String = ""

    fun resuelveAddOperacion(op: String = ""): String {
        if (op == "^2") {
            operando1 = if (operacion.isEmpty()) operando1 * operando1 else operando2 * operando2
            return operando1.toString()
        }

        if (op == "sqrt") {
            val resultado = calculaRaizCuadrada(if (operacion.isEmpty()) operando1 else operando2)
            if (operacion.isEmpty()) operando1 = resultado.toDoubleOrNull() ?: operando1
            else operando2 = resultado.toDoubleOrNull() ?: operando2
            return resultado
        }

        if (operacion.isNotEmpty()) {
            operando1 = when (operacion) {
                "+" -> operando1 + operando2
                "-" -> operando1 - operando2
                "*" -> operando1 * operando2
                "/" -> if (operando2 == 0.0) {
                    reset()
                    return "ERROR DIVISIÓN POR CERO"
                } else operando1 / operando2
                else -> operando1
            }
        }

        operacion = op
        operando2 = 0.0
        return operando1.toString()
    }

    fun calculaRaizCuadrada(n: Double): String {
        return if (n < 0.0) {
            reset()
            "ERROR: RAÍZ NEGATIVA"
        } else sqrt(n).toString()
    }

    fun reset() {
        operando1 = 0.0
        operando2 = 0.0
        operacion = ""
    }
}
