package com.libgdxgametemplate.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.libgdxgametemplate.game.ReflectionSample

object DesktopLauncherReflectionSampler {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        LwjglApplication(ReflectionSample(), config)
    }
}