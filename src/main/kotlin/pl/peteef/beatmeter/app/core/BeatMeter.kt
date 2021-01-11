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
import pl.peteef.beatmeter.engine.Engine

object BeatMeter : KtxScreen {
    private val stage = Stage()

    private val keyboardInputRecorder = KeyboardInputRecorder()
    private val engine = Engine(keyboardInputRecorder)

    private val font = BitmapFont().apply {
        data.setScale(1f)
    }

    private val batch = SpriteBatch().apply {
        color = Color.WHITE
    }

    override fun render(delta: Float) {
        batch.begin()
        batch.let {
            font.draw(it, engine.inputRecorder.values().lastOrNull().toString() , 20f, 580f)
        }
        batch.end()
    }

    override fun show() {
        keyboardInputRecorder.onInput { r -> println(r) }
        stage.addActor(keyboardInputRecorder.listener)
        keyboardInputRecorder.listener.setKeyboardFocus()
        Gdx.input.inputProcessor = InputMultiplexer(stage)
    }

    override fun dispose() {
        font.dispose()
        batch.dispose()
    }
}