// Bucle do while

fun main() {
    var num : Int = 0
    var dado = Math.random()*5+1
    do {
        print("Introduce un numero entre 1 y 5: ")
        num = readLine()!!.toInt()
    }while (num < 1 || num > 5)
    println("Ha salido el: " + dado.toInt())
    if (num == dado.toInt())
        println("Has ganado!!")
    else
        println("Mojonaso")
}