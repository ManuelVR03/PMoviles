// Creamos un rango con el operador ..
// Preguntamos con el operador in / !in

fun main() {
    val rango = 1..12
    if (6 in rango)
        println("El 6 está en el rango")
    if (15 !in rango)
        println("El 15 no está en el rango")
}