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


/** Un personaje ataca 3 veces a otro y se muestra el daño total causado
 *
 * @param player personaje del jugador
 * @param practiceDummy personaje del muñeco de prácticas
 */
fun ej03(player: PlayableCharacter, practiceDummy: PlayableCharacter) {
    var totalDamage = 0

    for (i in 0..2) {
        totalDamage += player.attack(practiceDummy)
    }

    practiceDummy.talk("he recibido $totalDamage puntos de daño")
}


/** Un personaje recoge 5 monedas 10 veces y cada vez que las recoge dice cuantas monedas tiene
 *
 * @param player personaje que recoge las monedas
 */
fun ej04(player: PlayableCharacter) {

    for (i in 0 until 10) {
        player.coins += 5
        player.talk("He recogido ${player.coins} monedas")
    }

}


/** Muestra el tipo de personaje según su nivel
 *
 * @param player personaje que se muestra
 */
fun ej05(player: PlayableCharacter) {
    val playerLevel = player.level

    when {
        playerLevel < 10 -> println("Personaje Principiante")
        playerLevel in 10..20 -> println("Personaje Intermedio")
       else -> println("Personaje Avanzado")
    }

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

        val pepe = PlayableCharacter("Pepe", 180, 11)
        val juan = PlayableCharacter("Juan", 140, 16)
        val practiceDummy = PlayableCharacter("Muñeco de practica", 999999999, 1)

        ej01(pepe)
        utilities.stop(1)

        ej02()
        utilities.stop(1)

        ej03(pepe, practiceDummy)
        utilities.stop(1)

        ej04(pepe)
        utilities.stop(2)

        ej05(pepe)
        pepe.levelUp(14)
        ej05(pepe)
        pepe.levelUp(33)
        ej05(pepe)
        utilities.stop(2)

        ej07(pepe, juan)
        utilities.stop(2)

    } catch (e: IllegalArgumentException) {
        println("*** ERROR *** - $e")
    } catch (e: Exception) {
        println("*** ERROR *** - Ha ocurrido un error inesperado: ($e)")
    }


}