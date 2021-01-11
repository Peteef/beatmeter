package pl.peteef.beatmeter.engine

import pl.peteef.beatmeter.engine.input.InputRecord
import pl.peteef.beatmeter.engine.input.InputRecorder

class Engine(
    val inputRecorder: InputRecorder<InputRecord>
) {
    init {
        inputRecorder.start()
    }
}