class Utilities {

    /** Para el hilo de ejecución
     *
     * @param time tiempo en segundos que se para el hilo de ejecución
     */
    fun stop(time: Long) {
        val sleepTime = time * 1000
        Thread.sleep(sleepTime)
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

}