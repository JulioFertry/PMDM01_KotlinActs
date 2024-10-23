class Menu {

    private val characters = Characters()


    fun askForOption(): String {
        print("Introduce la actividad (1-10) o 0 para salir: ")
        return readln()
    }

    fun performOption(option: String) {
        when (option) {
            "0" -> println("Adios")
            "1" -> Actividades.ej01(characters.pepe)
            "2" -> Actividades.ej02()
            "3" -> Actividades.ej03(characters.pepe, characters.practiceDummy)
            "4" -> Actividades.ej04(characters.pepe)
            "5" -> Actividades.ej05(characters.pepe)
            "6" -> Actividades.ej06(characters.pepe, characters.juan)
            "7" -> println("El ganador es: ${Actividades.ej07(characters.pepe, characters.juan).name}")
            "8" -> Actividades.ej08(characters.godofredo)
            "9" -> for (i in 1..4) { Actividades.ej09(characters.juan, characters.ramona) }
            "10" -> Actividades.ej10(characters.characters, characters.jefazo)
            else -> println("La opción introducida no existe...")
        }
    }

}