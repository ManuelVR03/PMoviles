import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {

    var n1=0;
    var n2=0;

    val tareaA=launch { n1=tarea("A",8) }
    tareaA.join()
    launch { n2=tarea("B") }.join()

    println (n1*n2)

    launch{tarea("C",7)}

    println("estoy en medio")

    launch { n1=tarea("D") }.join()
    launch { n2=tarea("E") }.join()

    println (n1*n2)

}