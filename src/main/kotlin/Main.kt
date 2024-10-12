/** Enfrenta a 2 personajes hasta que uno muere
 *
 * @param j1 jugador 1
 * @param j2 jugador 2
 */
fun ej07(j1: PlayableCharacter, j2: PlayableCharacter) {

    while (j1.isAlive() && j2.isAlive()) {
        j1.attack(j2)
        j2.attack(j1)
    }

}


/** Cura completamente a todos los personajes que reciba
 *
 * @param characters personajes que se van a curar
 */
fun healEverybody(characters: List<PlayableCharacter>) {
    characters.forEach { it.heal() }
}


fun main() {
    val utilities = Utilities()

    try {

        val pepe = PlayableCharacter("Pepe", 180, 20)
        val juan = PlayableCharacter("Juan", 140, 30)


        ej07(pepe, juan)
        utilities.stop(2)

    } catch (e: IllegalArgumentException) {
        println("*** ERROR *** - $e")
    } catch (e: Exception) {
        println("*** ERROR *** - Ha ocurrido un error inesperado: ($e)")
    }


}