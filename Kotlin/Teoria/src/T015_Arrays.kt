/*
    ByteArray
    IntArray
    ShortArray
    LongArray
    FloatArray
    DoubleArray
    BooleanArray
    CharArray
*/

fun main() {
    var numeros: IntArray
    numeros = IntArray(50)

    println(numeros.size) // Imprime 50

    for (i in 0 until numeros.size)
        numeros[i] = (Math.random()*100).toInt()

    for (i in 0..49)
        println(numeros[i])

    println("*************************")

    for (i in numeros.indices)
        numeros[i] = (Math.random()*1000).toInt()

    for(num in numeros)
        println(num)

    for((indice, elemento) in numeros.withIndex())
        println("En el índice $indice se almacena el elemento $elemento")
}