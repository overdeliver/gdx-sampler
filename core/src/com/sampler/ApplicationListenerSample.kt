package com.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger

class ApplicationListenerSample : ApplicationListener {

    override fun create() {
        // used to initialize game and load resources
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug("create()")
    }

    override fun resize(width: Int, height: Int) {
        // used to handle setting a new screen size
        log.debug("resize() width = $width height= $height")

    }

    override fun render() {
        // used to update and render the game elements called 60 times per second
        if (renderInterrupted) {
            log.debug("render()")
            renderInterrupted = false
        }
    }

    override fun pause() {
        // used to save game state when it loses focus, which does not involve the actual
        // game play being paused unles the developer wants it to pause
        log.debug("pause()")

    }

    override fun resume() {
        // used to handle the game coming back from being paused and restores game state
        log.debug("resume()")
        renderInterrupted = true
    }

    override fun dispose() {
        // used to free ressources and cleanup
        log.debug("dispose()")
    }

    companion object {
        private var renderInterrupted = true
        private val log = Logger(ApplicationListenerSample::class.java.name, Logger.DEBUG)
    }
}
