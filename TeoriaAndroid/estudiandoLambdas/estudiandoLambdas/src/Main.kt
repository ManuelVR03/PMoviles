//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// EJEMPLO DE USO DE OBJECT. PENSAR QUE SON SOLO VARIABLES CUYO FORMATO ES EL DE UN OBJETO
// CON SUS MÉTODOS Y ATRIBUTOS. PERO NO HAY QUE DEFINIR UNA CLASE PREVIAMENTE PARA ELLOS

object superMan :ISuperpoder {
    override fun volar() {
        println("Volar con capa")
    }
}

object ironMan :ISuperpoder {
    override fun volar() {
        println("Volar con motores")
    }
}



fun main() {


    // USO LOS OBJECT CREADOS COMO USARÍA CUALQUIER OBJETO.

    ironMan.volar()

    superMan.volar()

 //******************************************************************************************************


    //Aquí se usa superpoder como una funcion de orden superior.
    //Se ejecuta la función que está en la clase. Pero además dentro de dicha función
    //se ejecuta lo que está entre las llaves. se ejecutará (FUTURO) lo que está entre las
    //llaves

    val shazam: SuperHeroe = SuperHeroe()
    shazam.nombre = "Shazam"
    shazam.superpoder {
        println("Disparar rayos")
    }

    val spiderman: SuperHeroe = SuperHeroe()
    spiderman.nombre = "Spiderman"
    spiderman.superpoder {
        println("Subir por las paredes")
    }


  //*******************************************************************************
    /*
    EJEMPLO DE USO DE UNA COMO LA FN RESPIRAR ES UNA FUNCION DE ORDEN
    SUPERIOR QUE ADEMÁS ES ABSTRACTA Y SE IMPLEMENTA DE MANERA DIFERENTE
    EN LAS CLASES HIJAS Y LUEGO ACEPTA UNA LAMBDA
    */
    var perro:SerVivo=Mamifero()
    var tiburon:SerVivo=Pez()
    var trucha:SerVivo=Pez()

    println(
        perro.respirar {
        println("En el aire")
        }
    )
    println(tiburon.respirar { println("En agua salada") })
    println(trucha.respirar { println("En agua dulce") })
//*****************************************************************************

    //Otro ejemplo de uso de una función de orden superior
    // y el correspondiente lambda

    //1) DEFINO LA FUNCIÓN DE ORDEN SUPERIOR CON LAMBDA DENTRO (AÚN SIN DEFINIR LO QUE HARÁ)
    fun filtrarLista(list:MutableList<Int>, lambda: (l: MutableList<Int>) ->Int):Int{


        println("Hago un monton de cosas complicadas")
        return lambda(list)

    }

    var lista = mutableListOf<Int>(1,2,3,4)

    // 2) LLAMO A LA FUNCIÓN DE ORDEN SUPERIOR PASÁNDOLE LOS PARÁMETROS QUE NECESITA
    // Y DE PASO LE INYECTO AL FUNCIÓN LAMBDA
    var numero=filtrarLista(lista){
            var res:Int=0
            for (n in it){
                if (n%2!=0){
                    res+=n*3
                }
            }
            res

        }
    println ("El numero es : $numero")

}





