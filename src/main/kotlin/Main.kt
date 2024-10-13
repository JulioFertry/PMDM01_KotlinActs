/** Muestra a un personaje diciendo un mensaje
 *
 * @param player personaje que dice el mensaje
 */
fun ej01(player: PlayableCharacter) {
    player.talk("¡Hola, Mundo!")
}


/** Crea a eustaquio y muestra su vida */
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


/** Enfrenta a 2 personajes a una batalla con daño crítico activado hasta que uno muere
 *
 * @param p1 jugador 1
 * @param p2 jugador 2
 */
fun ej06(p1: PlayableCharacter, p2: PlayableCharacter) {
    p1.enableCriticAttacks()
    p2.enableCriticAttacks()

    while (p1.isAlive() && p2.isAlive()) {
        p1.attack(p2)
        p2.attack(p1)
    }

    p1.disableCriticAttacks()
    p2.disableCriticAttacks()
}


/** Enfrenta a 2 personajes hasta que uno muere
 *
 * @param p1 jugador 1
 * @param p2 jugador 2
 */
fun ej07(p1: PlayableCharacter, p2: PlayableCharacter): PlayableCharacter {

    while (p1.isAlive() && p2.isAlive()) {
        p1.attack(p2)
        p2.attack(p1)
    }

    return if (p1.isAlive()) {
        p1
    } else {
        p2
    }

}


/** Prueba la funcionalidad del inventario de un personaje
 *
 * @param player
 */
fun ej08(player: PlayableCharacter) {

    val bomb = Bomb(1)
    val bandage = Bandage(2)
    val radio = Radio(3)

    player.addToInventory(bomb)
    player.addToInventory(bandage)
    player.addToInventory(radio)

    player.showInventory()

    player.deleteItemById(1)
    player.deleteItemById(3)

    player.showInventory()

}


/** Enfrenta a 2 personajes y el ganador recibe 50 de experiencia, si el ganador llega a 200 de experiencia sube 1 nivel
 *
 * @param p1 jugador 1
 * @param p2 jugador 2
 */
fun ej09(p1: PlayableCharacter, p2: PlayableCharacter) {

    val winner = ej07(p1, p2)
    winner.experience += 50

    if (winner.experience >= 200) {
        winner.levelUp(1)
    }

}


/** Enfrenta a un grupo de personajes contra un personaje jefe hasta que muere el grupo o el jefe
 *
 * @param team grupo de personajes
 * @param boss personaje jefe
 */
fun ej10(team: List<PlayableCharacter>, boss: PlayableCharacter) {
    val aliveTeammates: MutableList<PlayableCharacter> = team.toMutableList()

    while (!isEverybodyDead(team) && boss.isAlive()) {

        team.forEach {
            it.attack(boss)
        }

        val teammate = team.random()
        boss.attack(teammate)

        if (!teammate.isAlive()) {
            aliveTeammates.remove(teammate)
        }
    }
}


/** Comprueba en una lista de personajes si todos han muerto
 *
 * @param characters lista de personajes
 *
 * @return true si han muerto todos, false si queda alguno vivo
 */
fun isEverybodyDead(characters: List<PlayableCharacter>): Boolean {
    var everybodyDied = false
    val totalCharacters = characters.size
    var deadCount = 0

    for (i in 0 until totalCharacters) {
        if (!characters[i].isAlive()) {
            deadCount += 1
        }
    }

    if (deadCount >= totalCharacters) {
        everybodyDied = true
    }

    return everybodyDied
}


/** Cura completamente a todos los personajes que reciba
 *
 * @param characters personajes que se van a curar
 */
fun healEverybody(characters: List<PlayableCharacter>) {
    characters.forEach { it.fullHeal() }
}


fun main() {
    val utilities = Utilities()

    try {

        val pepe = PlayableCharacter("Pepe", 200, 11)
        val juan = PlayableCharacter("Juan", 150, 14)
        val godofredo = PlayableCharacter("Godofredo", 70, 9)
        val ramona = PlayableCharacter("Ramona", 110, 7)
        val practiceDummy = PlayableCharacter("Muñeco de practica", 999999999, 1)
        val jefazo = PlayableCharacter("Jefazo", 500, 35)

        val characters = listOf(pepe, juan, godofredo, ramona)

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

        ej06(pepe, juan)
        healEverybody(characters)
        utilities.stop(3)

        val winner = ej07(pepe, juan)
        println("El ganador es ${winner.name}")
        healEverybody(characters)
        utilities.stop(3)

        ej08(godofredo)
        utilities.stop(3)

        ej09(juan, ramona)
        healEverybody(characters)
        ej09(juan, godofredo)
        healEverybody(characters)
        ej09(juan, ramona)
        healEverybody(characters)
        ej09(juan, godofredo)
        healEverybody(characters)
        juan.talk("soy nivel: ${juan.level}")
        utilities.stop(1)

        ej10(characters, jefazo)

    } catch (e: IllegalArgumentException) {
        println("*** ERROR *** - $e")
    } catch (e: Exception) {
        println("*** ERROR *** - Ha ocurrido un error inesperado: ($e)")
    }

}