package com.libgdxgametemplate.game.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.libgdxgametemplate.game.common.SampleBase
import com.libgdxgametemplate.game.utils.logger

class ModuleInfoSample : SampleBase() {

    companion object {
        @JvmStatic
        private val log = logger<ModuleInfoSample>()
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("app= ${Gdx.app}")
        log.debug("audio= ${Gdx.audio}")
        log.debug("input= ${Gdx.input}")
        log.debug("files= ${Gdx.files}")
        log.debug("net= ${Gdx.net}")

    }
}