package com.libgdxgametemplate.game

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.libgdxgametemplate.game.utils.logger

class InputListeningSample : ApplicationAdapter() {
    companion object {
        @JvmStatic
        private val log = logger<InputListeningSample>()
    }

    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        log.debug("create()")

        camera = OrthographicCamera()
        viewport = FitViewport(1080f, 720f, camera)
        batch = SpriteBatch()
        font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    // Clear screen
    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = camera.combined
        batch.begin()

        draw()

        batch.end()
    }

    // mouse / touch x/y
    private fun draw() {
        val mouseX = Gdx.input.x
        val mouseY = Gdx.input.y

        val leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT)
        val rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT)

        font.draw(batch, "Mouse x=$mouseX y=$mouseY ", 20f, 720f-20f)

        val leftPressedString = if(leftPressed) "Left button pressed" else "Left button not pressed"
        font.draw(batch, leftPressedString, 20f, 720f-50f)

        val rightPressedString = if(rightPressed) "Right button pressed" else "Right button not pressed"
        font.draw(batch, rightPressedString, 20f, 720f-80f)

        // keys
        val wPressed = Gdx.input.isKeyPressed(Input.Keys.W)
        val sPressed = Gdx.input.isKeyPressed(Input.Keys.S)

        font.draw(batch,
            if (wPressed) "W is pressed" else "W is not pressed",
                20f, 720f - 140f
                )

        font.draw(batch,
                if (sPressed) "S is pressed" else "S is not pressed",
                20f, 720f - 180f
        )
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }

}