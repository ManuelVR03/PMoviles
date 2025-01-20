import kotlinx.coroutines.*

fun main()= runBlocking {

    var n1=0;
    var n2=0;
    var tareaC: Job;
    
    n1 = async { tarea("A",8) }.await()
    n2 = async { tarea("B") }.await()

    println (n1*n2)

    tareaC = async{tarea("C",7)}

    println("estoy en medio")

    n1 = async { tarea("D") }.await()
    n2 = async { tarea("E") }.await()

    println(tareaC.await())

    println (n1*n2)

}