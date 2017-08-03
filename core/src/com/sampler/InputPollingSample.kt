package com.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class InputPollingSample : ApplicationListener {

    internal lateinit var camera: OrthographicCamera
    internal lateinit var viewport: Viewport
    internal lateinit var batch: SpriteBatch
    internal lateinit var font: BitmapFont

    override fun render() {
        // clear screen.
        Gdx.gl.glClearColor(0F, 0F, 0F, 1.0F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = camera.combined
        batch.begin()

        draw()

        batch.end()
    }

    fun draw() {
        // mouse / touch x/y
        val mouseX = Gdx.input.x
        val mouseY = Gdx.input.y

        // buttons
        val leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT)
        val rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT)

        font.draw(batch,
                "Mouse/Touch : x= $mouseX y= $mouseY",
                20F,
                720 - 20F)

        font.draw(batch,
                if(leftPressed) {
                    "Left button pressed"
                } else "Left button not pressed",
                20F,
                720 - 50F)

        font.draw(batch,
                if(rightPressed) {
                    "Right button pressed"
                } else
                    "Right button not pressed",
                20F,
                720 - 80F)

        val wPressed = Gdx.input.isKeyPressed(Input.Keys.W)
        val sPressed = Gdx.input.isKeyPressed(Input.Keys.S)

        font.draw(batch,
                if(wPressed) {
                    "W is pressed"
                } else "W is not pressed",
                20F,
                720 - 110F)

        font.draw(batch,
                if(sPressed) {
                    "S is pressed pressed"
                } else
                    "S is not pressed",
                20F,
                720 - 140F)
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        camera = OrthographicCamera()
        viewport = FitViewport(1080F, 720F, camera)
        batch = SpriteBatch()
        font = BitmapFont(Gdx.files.internal("/home/io/Projects/gdx-sampler/core/assets/fonts/oswald-32.fnt"))
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }



    companion object {
        private val log = Logger(ApplicationListenerSample::class.java.name, Logger.DEBUG)
    }
}
