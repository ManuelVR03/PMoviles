fun areaCuadrado(lado: Int) = lado*lado

fun main(){
    print("Introduce el lado del cuadrado: ")
    var lado = readln().toInt()
    var area = areaCuadrado(lado)
    println("El área es $area m2")
}