abstract class Item(val id: Int) {

    abstract val name: String

    /** Usa la acción del objeto */
    abstract fun use(character: PlayableCharacter)
}


class Bomb(id: Int) : Item(id) {

    override val name = "Bomba"

    /** Explota y hace daño al personaje que la tiene
     *
     * @param character personaje que tiene la bomba
     */
    override fun use(character: PlayableCharacter) {
        character.receiveDamage(400)
    }
}


class Radio(id: Int) : Item(id) {

    override val name = "Radio"

    /** Da las noticias
     *
     * @param character personaje que da las noticias
     */
    override fun use(character: PlayableCharacter) {
        println("Últimas noticias bla bla bla bla...")
    }
}


class Bandage(id: Int) : Item(id) {

    override val name = "Venda"

    /** Cura al personaje que la usa
     *
     * @param character Personaje que usa la venda
     */
    override fun use(character: PlayableCharacter) {
        character.heal(30)
    }
}