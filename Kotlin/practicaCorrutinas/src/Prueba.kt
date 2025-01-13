import kotlinx.coroutines.*
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

fun main() = runBlocking {
    val tareaA = async { "Hola" }
    println(tareaA.await())
}