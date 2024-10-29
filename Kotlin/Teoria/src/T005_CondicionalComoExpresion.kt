// Usamos la condicional if como expresión

fun main() {
    print("Introduce un numero: ")
    var num1 = readLine()!!.toInt()
    print("Introduce otro numero: ")
    var num2 = readLine()!!.toInt()
    val mayor = if (num1 > num2) num1 else num2
    val menor = if (num1 < num2) num1 else num2
    println("El mayor es: " + mayor)
    println("El menor es: " + menor)

}