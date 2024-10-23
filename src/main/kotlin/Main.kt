fun main() {

    val menu = Menu()
    val utilities = Utilities()
    var option = "opcion"

    try {

        while (option != "0") {
            option = menu.askForOption()
            menu.performOption(option)
            utilities.stop(3)
        }

    } catch (e: IllegalArgumentException) {
        println("*** ERROR *** - $e")
    } catch (e: NumberFormatException) {
        println("*** ERROR *** - al introducir un numero")
    } catch (e: Exception) {
        println("*** ERROR *** - Ha ocurrido un error inesperado: ($e)")
    }

}