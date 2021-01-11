package pl.peteef.beatmeter.app.core

import com.badlogic.gdx.Screen
import ktx.app.KtxGame

object KtxApp : KtxGame<Screen>() {
    override fun create() {
        addScreen(BeatMeter)
        setScreen<BeatMeter>()
    }
}