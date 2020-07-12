package com.libgdxgametemplate.game.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20


@JvmOverloads
fun clearScreen(color: Color = Color.BLACK)  = clearScreen(color.r, color.g, color.b, color.a)

fun clearScreen(red: Float, green: Float, blue: Float, alpha: Float) {
    // For clearing screen
// DRY - Don't repeat yourself
// WET - Waste everyone's time
    Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
}