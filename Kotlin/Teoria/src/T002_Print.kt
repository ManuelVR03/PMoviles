// Leer por consola
// Sacar por consola

fun main() {
    // Para leer usamos readLine()
    println("Introduce un número: ")
    val num1 = readLine()!!.toInt()
    println("Introduce otro número: ")
    val num2 = readLine()!!.toInt()
    val suma = num1 + num2
    println("La suma es: " + suma)
}