package com.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
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
        // clear screen
        Gdx.gl.glClearColor(0F, 0F, 0F, 1.0F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = camera.combined
        batch.begin()

        batch.end()
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        camera = OrthographicCamera()
        viewport = FitViewport(1080F, 720F, camera)
        batch = SpriteBatch()
        font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }

    companion object {
        private val log = Logger(ApplicationListenerSample::class.java.name, Logger.DEBUG)
    }
}