import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    GlobalScope.launch {
        for(x in 1..10) {
            print("$x -")
            delay(1000)
        }
    }
    println("Se bloquea el hilo principal del programa al llamar a readLine")
    readLine()
}