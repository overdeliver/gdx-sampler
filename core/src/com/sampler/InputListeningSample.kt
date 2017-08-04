package com.sampler

import com.badlogic.gdx.*
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class InputListeningSample : ApplicationListener, InputProcessor {

    companion object {
        private val log = Logger(InputListeningSample::class.java.name, Logger.DEBUG)
        const private val MAX_MESSAGE_COUNT = 15
        private val messages = Array<String>()
    }

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
        var i = 0
        while(i < messages.size) {
            font.draw(batch, messages.get(i),
                    20.0f,
                    720 - 40F * (i + 1))
            i++
        }
    }

    fun addMessage(message: String) {
        messages.add(message)

        if(messages.size > MAX_MESSAGE_COUNT) {
            messages.removeIndex(0)
        }
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

        Gdx.input.inputProcessor = this
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val message = "touchUp screenX = $screenX screenY= $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        val message = "mouseMoved screenX = $screenX screenY= $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun keyTyped(character: Char): Boolean {
        val message = "KeyTyped keycode= $character"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun scrolled(amount: Int): Boolean {
        val message = "scrolled amount = " + amount
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        val message = "KeypUp keycode = $keycode"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        val message = "touchDragged screenX = $screenX screenY= $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        val message = "keyDown keycode = $keycode"
        log.debug(message)
        addMessage(message)
        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val message = "touchDown screenX = $screenX screenY= $screenY"
        log.debug(message)
        addMessage(message)
        return true
    }
}
