package pl.peteef.beatmeter.app.core

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen

class MainScreen : KtxScreen {
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

    override fun dispose() {
        font.dispose()
        batch.dispose()
    }
}