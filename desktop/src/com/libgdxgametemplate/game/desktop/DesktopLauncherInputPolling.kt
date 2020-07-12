package com.libgdxgametemplate.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.libgdxgametemplate.game.InputPollingSample

object DesktopLauncherInputPolling {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width=1080
        config.height=720
        LwjglApplication(InputPollingSample(), config)
    }
}