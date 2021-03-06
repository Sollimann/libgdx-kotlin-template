package com.libgdxgametemplate.game.common

import com.libgdxgametemplate.game.samples.*

object SampleInfos {

    val allSamples = arrayListOf(
            SampleInfo(ApplicationListenerSample::class.java),
            SampleInfo(GdxGeneratedSample::class.java),
            SampleInfo(InputListeningSample::class.java),
            SampleInfo(InputPollingSample::class.java),
            SampleInfo(ModuleInfoSample::class.java),
            SampleInfo(MultiplexerSample::class.java),
            SampleInfo(ReflectionSample::class.java),
            SampleInfo(ViewportSample::class.java),
            SampleInfo(SpriteBatchSample::class.java),
            SampleInfo(OrthographicCameraSample::class.java),
            SampleInfo(ShapeRendererSample::class.java)
    )

    fun getSampleNames() = allSamples.associateBy { it.name }.keys.toList().sorted().toTypedArray()

    fun find(name: String) = allSamples.find { it.name == name }
}