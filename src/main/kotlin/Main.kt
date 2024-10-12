/** Muestra a un personaje diciendo un mensaje
 *
 * @param player personaje que dice el mensaje
 */
fun ej01(player: PlayableCharacter) {
    player.talk("¡Hola, Mundo!")
}


/** Crea a eustaquio y muestra su vida
 */
fun ej02() {
    val name = "Eustaquio"
    val health = 100
    val damage = 50

    val eustaquio = PlayableCharacter(name, health, damage)
    println("La vida de ${eustaquio.name} es de ${eustaquio.maxHealthPoints}")
}


/** Enfrenta a 2 personajes hasta que uno muere
 *
 * @param p1 jugador 1
 * @param p2 jugador 2
 */
fun ej07(p1: PlayableCharacter, p2: PlayableCharacter) {

    while (p1.isAlive() && p2.isAlive()) {
        p1.attack(p2)
        p2.attack(p1)
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

        ej01(pepe)
        utilities.stop(2)

        ej02()
        utilities.stop(2)

        ej07(pepe, juan)
        utilities.stop(2)

    } catch (e: IllegalArgumentException) {
        println("*** ERROR *** - $e")
    } catch (e: Exception) {
        println("*** ERROR *** - Ha ocurrido un error inesperado: ($e)")
    }


}