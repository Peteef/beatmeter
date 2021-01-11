package pl.peteef.beatmeter.app.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import ktx.actors.setKeyboardFocus
import ktx.app.KtxScreen
import pl.peteef.beatmeter.app.input.KeyboardInputRecorder

object BeatMeter : KtxScreen {
    val stage = Stage()

    private val font = BitmapFont().apply {
        data.setScale(3f)
    }

    private val batch = SpriteBatch().apply {
        color = Color.WHITE
    }

    override fun render(delta: Float) {
        batch.begin()
        batch.let {
            font.draw(it, "Hello Beatmeter!", 0f, 600f)
        }
        batch.end()
    }

    override fun show() {
        val recorder = KeyboardInputRecorder()
        recorder.onInput { r -> println(r) }
        stage.addActor(recorder.listener)
        recorder.listener.setKeyboardFocus()
        Gdx.input.inputProcessor = InputMultiplexer(stage)
        recorder.start()
    }

    override fun dispose() {
        font.dispose()
        batch.dispose()
    }
}