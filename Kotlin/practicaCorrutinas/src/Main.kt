import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

/*
runBlocking crea un espacio propio para lanzar corrutinas y hace que:
1) Lo que esté dentro del mismo se ejecute secuencialmente
    Excepto las corrutinas que se lancen con launch que serán asíncronas
2) Bloquea el hilo en el que se encuentra, y por tanto
    nada de lo que haya después se ejecutará hasta terminar el bloque
3) si se asocia a main, entonces creará un espacio para lanzar corrutinas en el ámbito
    del main. El funcionamiento es el mismo que antes. Todas las instrucciones son
    secuenciales, excepto las corrutinas que se lancen con launch que son asíncronas
4) se pueden crear runBlocking anidados, pero no es la mejor práctica para sincronizar,
    mejor usar join

*/
// FUNCIONAMIENTO DEL PROGRAMA:
// secuencia programada. (A | B) significa que se ejecutarán a la vez
// hiloMain -> (A | B) C (D | E)
// si hago A.join entonces fuerzo a que A termine antes que B y quedaría así:
// hiloMain -> (A B) C (D y E)

/*
    Podría hacer toda la secuencia desde un solo runBlocking en el main
    necesario para poder lanzar corrutinas en un espacio de trabajo
    pero luego podemos sincronizar todas las tareas usando launch y join
    (Hacer como ejercicio)

*/


fun main()= runBlocking {

        var n1=0;
        var n2=0;

    runBlocking {
        val tareaA=launch { n1=tarea("A",8) }
       // tareaA.join() // si quiero forzar a que tareaA termine ante que la siguiente corrutina
        launch { n2=tarea("B") }
    }

    println (n1*n2)
    launch{tarea("C",7)}
    println("estoy en medio")
    runBlocking {
        launch { n1=tarea("D") }
        launch { n2=tarea("E") }
    }
    println (n1*n2)

}
// si no se especifica el tiempo (t) en segundos, se establece un tiempo aleatorio entre 1 y 5 segundos
// La tarea devuelve un número aleatorio entre 1 y 10

suspend fun tarea(nombre:String , t:Long= Random.nextLong(1L, 6L)):Int{

    delay(t*1000)
    println("Tarea $nombre completada después de ${t} segundos")
    return Random.nextInt(1, 11)

}