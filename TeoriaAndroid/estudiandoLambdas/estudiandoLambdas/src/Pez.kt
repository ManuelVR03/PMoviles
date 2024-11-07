class Pez: SerVivo(){
    override fun respirar(fn: () -> Unit) {
       println("Respira por branquias")
       fn()
    }
}