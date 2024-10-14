package com.example.ejercicioskotlin

fun main(){

   //ejemplo de uso de una función dentro de otra.
    val v1=10; val v2=5
    val z = operacion(v1, v2, sumar (v1,v2))

  //Ejemplo de pasar una función como referencia
    var x = operar(v1, v2, ::sumar)
    var y =operar(v1, v2, ::restar)


  //Igual que la anterior pero en este caso es una función anónima
  // Ya que no tiene nombre. En este caso multiplica

    x=operar (v1, v2, {x,y -> x*y})


  // si lo último que se escribe es la función, la sentencia
  // se puede reescribir así

    y=operar (v1, v2){x,y-> x+2*y}

/*
    La función Lambda es lo escrito entre {}.
    En este caso se está usando para ser pasada como argumento
    una función de orden superior que la utiliza.
    Pero no es necesario usar una función de orden superior
    con el uso de la función lambda. Por ejemplo
 */


    var suma={v1:Int,v2:Int->v1*v2}
    println (suma(2,3))

    //Si se usa un solo parámetro de entrada puede omitirse junto
    // con el operador -> Por ejemplo.
    var esPar = { it: Int -> it % 2 == 0 }
    //o también:
    var esNumPar: (Int) -> Boolean = { it % 2 == 0 }
    //Es necesario definir el contexto de it ya que no está previamente definido
    //en una función superior. Por ejemplo

    //Imprime si es multiplo de tres. Aquí no hace falta declarar it ya que está hecho
    //en la función de orden superior

    println(operarUnitario(5){it%3==0})

    //La biblioteca de Kotlin y los componentes de Android están llenos
    //de funciones de orden superior. Por ejemplo para manejar eventos
    //Vease el código del Activity

    /*
     Cuando una función se pasa como referencia, por ejemplo una función lambda,
     a una función de orden superior que la utiliza, esta última puede controlar
     en que momento se ejecutará. Esto es útil para gestionar la asincronia.
     Las funciones que se pasan como argumento y se ejecutan más tarde después de
     producirse otro proceso asíncrono se llaman callbacks
    */
    // Primer ejemplo una función con retardo es llamada de manera sincrona
    // el programa quedará bloqueado hasta que se ejecute el proceso con retardo
    imprimeNúmeroSincrono()
    //Segundo ejemplo, pretendo esperar a que se devuelva el número en segundo plano
    //pero el que está en primer plano lo adelanta y muestra unos resultados incorrectos
    val numero=getNumeroAsincronoMal()
    println("el numero con asincronía mal hecha es el $numero")
    //Tercer ejemplo. se imprime el numero correctamente usando un callbacks.
    // la función no hace nada especial. Solo imprime un número, pero al pasarse como
    // argumento de otra función de orden superior, esta la ejecutará solo cuando
    //el proceso termine.
    //getNumeroCallBack{numero->println("el numero con callback es el $numero")}
     getNumeroCallBack{println("el numero con callback es el $it")}

    println("procesando datos de callback")

}


//Funciones de orden superior
//Una función recibe como parámetro no el resultado de otra función ya definida,
//sino cualquier otra función que encaje con la firma de la función llamada

fun operarUnitario(v1:Int, fn: (Int)->Boolean):Boolean {
    return fn(v1)
}

fun operar(v1: Int, v2: Int, fn: (Int, Int) -> Int) : Int {
    var resultado:Int=0
    println("voy a operar con los datos $v1 y $v2, el resultado aún sin determinar")
    println("el resultado es: $resultado")
    //Ahora es cuando de verdad llamamos a la función
    resultado=fn(v1, v2)
    println("Calculo terminado. El resultado es: $resultado")
    return resultado
}

fun restar(i: Int, i1: Int): Int {
    return i-i1
}
fun sumar(x1: Int, x2: Int) = x1 + x2

// Función normal que recoge el resultado de otra función
fun operacion(v1:Int, v2:Int, resultado: Int): Any {

    println("voy a operar con los datos $v1 y $v2, El resultado ya está procesado")
    println("el resultado es: $resultado")
    //No ocurre nada especial, la función ya fué llamada
    println("Calculo terminado. El resultado es: $resultado")
    return resultado
}

/*
 Funciones para ejemplificar el uso de las funciones lambda como callbaks
 y manejo de la asincronía

*/
// Función que simula un retardo en el tiempo. Por ejemplo un cálculo
// en el tiempo o un acceso a una Bd
fun devuelveNumeroConRetardo():Int{
    Thread.sleep(2000); //espera 2 segundos
    return 100;
}

fun imprimeNúmeroSincrono() {
    val numero=devuelveNumeroConRetardo()
    println("El número solicitado es el $numero")
}

// Con métodos asíncronos no se puede hacer un return sin más
fun getNumeroAsincronoMal():Int{
    val numero=0
    Thread{
        devuelveNumeroConRetardo()
    }.start()
    return numero
}
// En su lugar usaría una función anónima (lambda) que recogería el dato cuando
//estuviese listo y lo procesaría como quisiese (según lo que se defina en la función lambda)
fun getNumeroCallBack(fn:(Int)->Unit){

    Thread{
        val numero=devuelveNumeroConRetardo()
        fn(numero)
    }.start()

}
