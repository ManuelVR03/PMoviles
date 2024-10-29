// Bucle for y variantes

fun main() {
    println("** For en rango **")
    for (i in 1..10)
        println(i)

    println()

    println("** For de 2 en 2")
    for (i in 1..10 step 2)
        println(i)

    println()

    println("** For decreciente")
    for (i in 10 downTo 1)
        println(i)

    println()

    println("** For decreciente de 2 en 2")
    for (i in 10 downTo 1 step 2)
        println(i)

}