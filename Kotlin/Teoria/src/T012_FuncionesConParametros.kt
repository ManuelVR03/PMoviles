fun mostrar(mensaje: String){
    println(mensaje)
}

fun sumar(x: Int, y: Int){
    var suma = x + y
    mostrar("El resultado es: " + suma)
}

fun main() {
    mostrar("Vamos a sumar 2 números")
    sumar(5, 3)
}