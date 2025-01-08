import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

fun main(args: Array<String>) {
    val adivina = Random.nextInt(1, 100)
    var inicio = 1
    var fin = 100
    GlobalScope.launch {
        var pienso:Int
        do {
            pienso = Random.nextInt(inicio, fin)
            println(pienso)
            if (pienso == adivina)
                println("Gane con el $pienso")
            else
                if (pienso < adivina) {
                    println("El numero es mayor")
                    inicio = pienso
                } else {
                    println("El numero es menor")
                    fin = pienso
                }
            delay(500)
        } while (pienso != adivina)
    }
    readLine() //detenemos el hilo principal del programa
}