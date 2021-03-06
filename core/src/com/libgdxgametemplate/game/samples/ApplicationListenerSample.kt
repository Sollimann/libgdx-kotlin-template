package com.libgdxgametemplate.game.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.libgdxgametemplate.game.common.SampleBase
import com.libgdxgametemplate.game.utils.logger

class ApplicationListenerSample : SampleBase() {

    companion object {
        @JvmStatic
        private val log = logger<ApplicationListenerSample>()
    }


    private var renderInterrupted = true

    // Used to render the game elements (at 60fps)
    override fun render() {
        if(renderInterrupted) {
            log.debug("render()")
            renderInterrupted = false
        }
    }

    // Used to save game state when it loses focus, which doesn't involve
    // the actual game play being paused unless the developer wants to pause
    override fun pause() {
        log.debug(("pause()"))
        renderInterrupted = true
    }

    // Used to handle the gaming coming back from being paused
    override fun resume() {
        log.debug(("resume()"))
        renderInterrupted = true

    }

    // Used to handle setting a new screen size
    override fun resize(width: Int, height: Int) {
        log.debug("resize()")
    }

    // Initialize game and load resources
    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug("create()")
    }

    // Used to free resources and clean up
    override fun dispose() {
        log.debug("dispose()")
    }


}