class PlayableCharacter(val name: String, hp: Int, damage: Int) {

    private var healthPoints = hp
    val maxHealthPoints = hp
    private var attackDamage = damage


    init {
        verifyName(name)
        verifyHealthPoints(hp)
        verifyDamage(damage)
    }


    /** Comprueba si el personaje sigue vivo
     *
     * @return true si sigue vivo, false si ha muerto
     */
    fun isAlive(): Boolean {
        return healthPoints > 0
    }


    /** Ataca a otro personaje aplicando daño aleatorio seguún su attackDamage
     *
     * @param enemy personaje al que se ataca
     */
    fun attack(enemy: PlayableCharacter) {
        if (isAlive()) {
            val damage = (1..attackDamage).random()
            enemy.receiveDamage(damage)
        }
    }


    /** Cura completamente al personaje
     */
    fun heal() {
        healthPoints = maxHealthPoints
    }


    /** Calcula el daño que recibe el personaje, lo aplica a su vida total y muestra un mensaje
     *
     * @param damage daño que recibe el personaje
     */
    private fun receiveDamage(damage: Int) {
        healthPoints -= damage
        print("$name ha recibido $damage puntos de daño")

        if (healthPoints <= 0) {
            println(", ha muerto!")
        } else {
            println(", le quedan $healthPoints puntos de vida\n")
        }

    }


    /** El personaje dice un mensaje que se muestra por pantalla
     *
     * @param message texto a mostrar
     */
    fun talk(message: String) {
        println("$name dice: $message")
    }


    /** Comprueba que nombre del personaje no esté vacío o en blanco
     *
     * @param name nombre del personaje
     */
    private fun verifyName(name: String) {
        require(name.isNotBlank() && name.isNotEmpty()) {"El personaje debe tener un nombre"}
    }

    /** Comprueba que la vida del personaje sea superior a 0 puntos
     *
     * @param hp vida del personaje
     */
    private fun verifyHealthPoints(hp: Int) {
        require(hp > 0) {"La vida del personaje no puede ser inferior a 1"}
    }

    /** Comprueba que el ataque del personaje sea superior a 0 puntos
     *
     * @param damage daño del personaje
     */
    private fun verifyDamage(damage: Int) {
        require(damage > 0) {"El ataque del personaje no puede ser inferior a 1"}
    }


}