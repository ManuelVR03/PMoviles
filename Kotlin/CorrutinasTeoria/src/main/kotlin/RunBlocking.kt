import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    launch {
        delay(1000)
        println("Paso un segundo")
    }
    println("Iniciando")
}