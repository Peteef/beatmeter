package pl.peteef.beatmeter.app

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import pl.peteef.beatmeter.app.core.KtxApp

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello Beatmeter!")
        LwjglApplication(KtxApp(), LwjglApplicationConfiguration().apply {
            title = "Beatmeter"
            width = 800
            height = 600
            resizable = false
        })
    }
}