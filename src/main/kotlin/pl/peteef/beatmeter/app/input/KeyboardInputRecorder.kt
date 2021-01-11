package pl.peteef.beatmeter.app.input

import com.badlogic.gdx.scenes.scene2d.Actor
import ktx.actors.onKeyDown
import pl.peteef.beatmeter.engine.input.InputRecord
import pl.peteef.beatmeter.engine.input.InputRecorder
import java.time.Instant

class KeyboardInputRecorder : InputRecorder<InputRecord> {
    val listener = Actor().apply {
        onKeyDown {
            keyCode -> record(keyCode)
        }
    }

    private var isStarted = false
    private val records: MutableList<InputRecord> = mutableListOf()
    private var handleInput: (InputRecord) -> Unit = {}

    override fun start() {
        isStarted = true
    }

    override fun stop() {
        isStarted = false
    }

    override fun values(): List<InputRecord> = records

    private fun record(keyCode: Int) {
        if (isStarted) {
            val id = records.size + 1
            val timestamp = Instant.now()
            val delta = records.lastOrNull()?.timestamp?.let { previous -> timestamp.minusMillis(previous.toEpochMilli()).toEpochMilli() } ?: 0
            val record = InputRecord(id, keyCode, timestamp, delta)
            records.add(record)
            handleInput(record)

        }
    }

    override fun onInput(handler: (InputRecord) -> Unit) {
        this.handleInput = handler
    }
}