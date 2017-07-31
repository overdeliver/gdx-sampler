package com.sampler.desktop

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.sampler.GdxModuleInfoSample

object DesktopLauncherGdxModuleInfoSample {
    @JvmStatic fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()

        println("app= " + Gdx.app)
        println("input= " + Gdx.input)

        LwjglApplication(GdxModuleInfoSample(), config)

        println("after app = " + Gdx.app)
        println("after input = " + Gdx.input)
    }
}
