class Utilities {

    /** Para el hilo de ejecución
     *
     * @param time tiempo en segundos que se para el hilo de ejecución
     */
    fun stop(time: Long) {
        val sleepTime = time * 1000
        Thread.sleep(sleepTime)
    }

}