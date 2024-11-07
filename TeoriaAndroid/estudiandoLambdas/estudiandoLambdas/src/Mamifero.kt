class Mamifero:SerVivo() {
    override fun respirar(fn: () -> Unit) {
        println("respira con pulmones")
        fn()
    }
}