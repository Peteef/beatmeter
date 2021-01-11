package pl.peteef.beatmeter.app.input

import com.badlogic.gdx.scenes.scene2d.Actor
import ktx.actors.onKeyDown
import pl.peteef.beatmeter.engine.input.InputRecorder
import java.time.LocalTime

class KeyboardInputRecorder : InputRecorder<String> {
    val listener = Actor().apply {
        onKeyDown {
            keyCode -> record(keyCode)
        }
    }

    private var isStarted = false
    private val records: MutableList<String> = mutableListOf()
    private var handleInput: (String) -> Unit = {}

    override fun start() {
        isStarted = true
    }

    override fun stop() {
        isStarted = false
    }

    override fun values(): List<String> = records

    private fun record(keyCode: Int) {
        if (isStarted) {
            val timestamp = LocalTime.now()
            val record = "$keyCode $timestamp"
            records.add(record)
            handleInput(record)

        }
    }

    override fun onInput(handler: (String) -> Unit) {
        this.handleInput = handler
    }
}