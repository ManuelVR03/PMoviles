class Persona (var nombre: String, var edad: Int){

    fun imprimir(){
        println("Nombre: $nombre y tiene $edad años.")
    }

    fun esMayorEdad(){
        if (edad >= 18)
            println("Es mayor de edad.")
        else
            println("No es mayor de edad.")
    }
}

fun main(){
    val persona1 = Persona("Manuel", 21)
    persona1.imprimir()
    persona1.esMayorEdad()
}