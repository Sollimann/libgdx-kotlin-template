package com.libgdxgametemplate.game.desktop

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.libgdxgametemplate.game.ModuleInfoSample

object DesktopLauncherGdxModuleInfo {
    @JvmStatic
    fun main(arg: Array<String>) {

        println("app= ${Gdx.app}")
        println("input= ${Gdx.input}")

        val config = LwjglApplicationConfiguration()
        LwjglApplication(ModuleInfoSample(), config)


        println("app= ${Gdx.app}")
        println("input= ${Gdx.input}")
    }
}