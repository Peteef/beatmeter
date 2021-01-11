package pl.peteef.beatmeter.engine.input

interface InputRecorder<T> {
    fun start()
    fun stop()
    fun values(): List<T>
    fun onInput(handler: (T) -> Unit)
}