fun main() {
    // Reprograma la funcion repeat para que haga lo mismo que la que está incorporada en kotlin

    val mascotas = arrayOf("Perro", "Gato", "Loro", "Hamster", "Cobaya")

    // Recorrer el array con un bucle for
    println("Bucle for")
    for (i in mascotas.indices){
        println(mascotas[i])
    }
    println()

    // Recorrer el array con un bucle for each
    println("Bucle for each")
    for (mascota in mascotas){
        println(mascota)
    }
    println()

    // Recorrer el array con un bucle for indexes
    println("Bucle for indexes")
    for ((index, mascota) in mascotas.withIndex()) {
        println("$index $mascota")
    }
    println()

    // Recorrer el array con repeat
    println("Repeat")
    repeat(mascotas.size){
        println(mascotas[it])
    }
    println()

    // Recorrer el array con miRepeat
    println("Mi Repeat")
    fun miRepeat(i: Int, fn: (Int) -> Unit){
        for (index in 0 until i){
            fn(index)
        }
    }
    miRepeat(mascotas.size){
        println(mascotas[it])
    }
    println()
    miRepeat(5){
        println("Hola")
    }
}