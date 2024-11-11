package com.example.manuelverdejo.modelo

data class Alimento(
    val nombre: String,
    val grProt: Double,
    val grHC: Double,
    val grLip: Double,
    val cantidad: Double,
    val KcalTotales: Double = calculaKcal(grProt, grHC, grLip, cantidad)
)

fun calculaKcal(grProt: Double, grHC: Double, grLip: Double, cantidad: Double): Double {
    return 4*cantidad/100*grProt+4*cantidad/100*grHC+4*cantidad/100*grLip
}
