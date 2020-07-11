package com.libgdxgametemplate.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.libgdxgametemplate.game.ApplicationListenerSampler
import com.libgdxgametemplate.game.LibgdxGame

object ApplicationListenerDesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        LwjglApplication(ApplicationListenerSampler(), config)
    }
}