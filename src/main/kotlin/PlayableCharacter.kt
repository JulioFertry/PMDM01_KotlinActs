class PlayableCharacter(val name: String, hp: Int, damage: Int) {

    private var healthPoints = hp
    val maxHealthPoints = hp
    var level = 1

    private var attackDamage = damage
        set(value) {
            verifyDamage(value)
            field = value
        }

    var coins = 0
        set(value) {
            verifyCoins(value)
            field = value
        }


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


    /** Devuelve el daño de ataque randomizado y multiplicado por 5
     *
     * @return daño multiplicado
     */
    private fun attackMultiplier(): Int {
        return (attackDamage/2..attackDamage).random() * 5
    }


    /** Ataca a otro personaje aplicando daño aleatorio seguún su attackDamage
     *
     * @param enemy personaje al que se ataca
     */
    fun attack(enemy: PlayableCharacter): Int {
        var damage = 0

        if (isAlive()) {
            damage = attackMultiplier()
            enemy.receiveDamage(damage)
        }

        return damage
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


    /** Sube el nivel del personaje tantos niveles como reciba
     *
     * @param levels cantidad de niveles que sube
     */
    fun levelUp(levels: Int) {
        level += levels
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
        require(hp > 0) {"La vida de un personaje no puede ser inferior a 1"}
    }

    /** Comprueba que el ataque del personaje sea superior a 0 puntos
     *
     * @param damage daño del personaje
     */
    private fun verifyDamage(damage: Int) {
        require(damage > 0) {"El ataque de un personaje no puede ser inferior a 1"}
    }

    /** Comprueba que el personaje no tenga menos de 0 monedas
     *
     * @param coins monedas del personaje
     */
    private fun verifyCoins(coins: Int) {
        require(coins >= 0) {"Un personaje no puede tener monedas negativas"}
    }

}