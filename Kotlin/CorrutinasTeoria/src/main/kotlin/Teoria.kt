import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    var num1 = 0
    var num2 = 0
    var num3 = 0

    num1 = procesarDato1Servidor()
    println("Número 1: " + num1)

    procesarDato2Servidor() {
        num2 = it
        println("Número 2: " + num2)
    }

    println("Hago cosas")

    runBlocking {
        launch {
            num3 = procesarDato3Servidor()
            println("Número 3: " + num3)
        }
    }

    println("Yo sigo haciendo cosas")

    readln()
}

fun procesarDato1Servidor(): Int {
    var n = 0
    Thread {
        Thread.sleep(5000)
        n = 1
    }.start()
    return n
}

fun procesarDato2Servidor(callback: (dato: Int) -> Unit){

    var n = 0
    Thread {
        Thread.sleep(5000)
        n = 10
        callback(n)
    }.start()

}

suspend fun procesarDato3Servidor(): Int {
    var n = 0
    delay(3000)
    n = 100
    return n
}