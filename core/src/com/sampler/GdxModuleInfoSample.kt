package com.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Logger


class GdxModuleInfoSample: ApplicationListener {

    override fun render() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug("app=" + Gdx.app)
        log.debug("audio=" + Gdx.audio)
        log.debug("input=" + Gdx.input)
        log.debug("files=" + Gdx.files)
        log.debug("net=" + Gdx.net)
        log.debug("graphics=" + Gdx.graphics)
    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private val log = Logger(ApplicationListenerSample::class.java.name, Logger.DEBUG)
    }

}