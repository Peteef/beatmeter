package pl.peteef.beatmeter.engine.input

import java.time.Instant

data class InputRecord(val id: Int, val keyCode: Int, val timestamp: Instant, val delta: Long)
