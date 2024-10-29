// Condicional when

fun main() {
    val num = readLine()!!.toInt()
    when (num) {
        1 -> print("uno")
        2 -> print("dos")
        3 -> print("tres")
        4 -> print("cuatro")
        5 -> print("cinco")
        else -> print("Hasta el 5 si churrita")
    }
}