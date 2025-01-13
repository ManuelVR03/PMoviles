import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    var numero1=0 //1
    var numero2=0
    var numero3=0

    numero1=procesarDato1Servidor()
    println(numero1)

   procesarDato2Servidor(){
        numero2=it
        println(numero2)

   }

   //SOLUCION 2 USANDO CORROUTINES

        launch {
            numero3 = procesarDato3Servidor()
            println(numero3)


    }


    println("yo sigo haciendo mis cosas")






  }

//PROBLEMA: No funciona como queremos. el valor de n se devuelve antes de tiempo
fun procesarDato1Servidor(): Int {
    var n=0
    Thread{
        Thread.sleep(5000)
        n=1

    }.start()
    return n
}
//SOLUCIÓN 1: USO DE UNA FUNCIÓN ANÓNIMA (CALLBACK)
fun procesarDato2Servidor(callback:(dato:Int)->Unit) {

    Thread{
        Thread.sleep(1000)
        var n=10 //se calcula el numero
        callback(n)
    }.start()

}


//SOLUCIÓN 2: USO DE CORROUTINES
suspend fun procesarDato3Servidor():Int {

    delay(3000)
    return 100

}
