package com.libgdxgametemplate.game.samples

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.libgdxgametemplate.game.common.SampleBase
import com.libgdxgametemplate.game.utils.clearScreen
import com.libgdxgametemplate.game.utils.logger

class ShapeRendererSample : SampleBase() {

    companion object{
        @JvmStatic
        private val log = logger<ShapeRendererSample>()

        private const val WORLD_WIDTH = 40f // world units
        private const val WORLD_HEIGHT = 20f // world units
    }

    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: Viewport
    private lateinit var renderer: ShapeRenderer

    private var drawGrid = true
    private var drawCircles = true
    private var drawRectangles = true
    private var drawPoints = true

    override fun create() {
        camera = OrthographicCamera()
        viewport = FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)
        renderer = ShapeRenderer()

        Gdx.input.inputProcessor = this
    }

    override fun render() {
        clearScreen()

        renderer.projectionMatrix = camera.combined

        if(drawGrid) {
            drawGrid()
        }
    }

    private fun drawGrid() {
        renderer.begin(ShapeRenderer.ShapeType.Line)
        renderer.color = Color.WHITE

        val worldWidth = WORLD_WIDTH.toInt()
        val worldHeight = WORLD_HEIGHT.toInt()

        // horizontal lines
        for(y in -worldHeight until worldHeight){
            renderer.line(-worldWidth.toFloat(), y.toFloat(), worldWidth.toFloat(), y.toFloat())
        }

        // vertical lines
        for(x in -worldWidth until worldHeight){
            renderer.line(x.toFloat(), -worldHeight.toFloat(), x.toFloat(), worldHeight.toFloat())
        }

        renderer.color = Color.RED
        renderer.line(-worldWidth.toFloat(), 0f, worldWidth.toFloat(), 0f)
        renderer.line(0f, -worldHeight.toFloat(), 0f, worldHeight.toFloat())

        renderer.end()
    }

    override fun keyDown(keycode: Int): Boolean {
        when(keycode) {
            Input.Keys.G -> drawGrid = !drawGrid
            Input.Keys.C -> drawCircles = !drawCircles
            Input.Keys.R -> drawRectangles = !drawRectangles
            Input.Keys.P -> drawPoints = !drawPoints
        }
        return true
    }

    override fun resize(width: Int, height: Int) {
        // NOTE: not centering camera
        viewport.update(width, height, false)
    }

    override fun dispose() {
        renderer.dispose()
    }
}