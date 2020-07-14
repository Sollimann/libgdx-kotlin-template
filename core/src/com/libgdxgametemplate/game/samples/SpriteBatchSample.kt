package com.libgdxgametemplate.game.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.libgdxgametemplate.game.common.SampleBase
import com.libgdxgametemplate.game.utils.clearScreen
import com.libgdxgametemplate.game.utils.logger
import com.libgdxgametemplate.game.utils.toInternalFile
import com.libgdxgametemplate.game.utils.use

class SpriteBatchSample : SampleBase() {
    companion object {
        @JvmStatic
        private val log = logger<SpriteBatchSample>()
    }

    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: Viewport
    private lateinit var batch: SpriteBatch
    private lateinit var texture: Texture

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("create()")

        camera = OrthographicCamera()
        viewport = FitViewport(10.8f, 7.2f, camera)
        batch = SpriteBatch()
        texture = Texture("raw/character.png".toInternalFile())
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    // Clear screen
    override fun render() {
        clearScreen()

        batch.projectionMatrix = camera.combined

        /*
        batch.begin()
        draw()
        batch.end()
         */

        batch.use {draw()}
    }

    // mouse / touch x/y
    private fun draw() {
        val width = 1f // world units
        val height = 1f // world units

        batch.draw(texture, 1f, 1f, width / 2f, height / 2f, width, height,
                1f, 1f, 0f, 0, 0, texture.width, texture.height,
                false, false)

        // scaled
        batch.draw(texture, 4f, 2f, width/2f, height/2f, width,height,
                2f, 2f, 0f, 0, 0,texture.width, texture.height,
                false, false)

        // batch color
        val oldColor = batch.color
        batch.color = Color.GREEN


        batch.draw(texture, 8f, 1f, width/2f, height/2f, width,height,
                1f, 1f, 0f, 0, 0,texture.width, texture.height,
                false, false)


        batch.color = oldColor

    }

    override fun dispose() {
        log.debug("dispose()")
        batch.dispose()
        texture.dispose()
    }

}