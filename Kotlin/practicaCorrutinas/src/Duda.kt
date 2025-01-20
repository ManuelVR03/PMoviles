import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    var texto = "nada"
    var _job = launch {
        delay(2000)
        texto = "Hola"
    }
    // _job.join()
    println(texto)
    _job.join()
    println(texto)
    var _deferred = async {
        delay(3000)
        "Mundo"
    }
    //texto = _deferred.await()
    println(_deferred.await())
}