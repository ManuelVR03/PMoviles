class SuperHeroe {

    var nombre:String=""

    fun superpoder(lambda:()->Unit) {

        println("Soy $nombre y voy a ...")
        lambda()

    }
}