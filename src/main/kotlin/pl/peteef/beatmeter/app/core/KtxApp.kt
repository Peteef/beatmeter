package pl.peteef.beatmeter.app.core

import com.badlogic.gdx.Screen
import ktx.app.KtxGame

class KtxApp : KtxGame<Screen>() {
    override fun create() {
        addScreen(MainScreen())
        setScreen<MainScreen>()
    }
}