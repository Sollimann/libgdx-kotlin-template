package com.libgdxgametemplate.game.desktop

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas
import com.badlogic.gdx.utils.reflect.ClassReflection
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*

class GdxSamplerLauncher : JFrame() {

    private val windowWidth = 1280
    private val windowHeight = 720
    private val windowSize = Dimension(windowWidth, windowHeight)
    private val cellWidth = 200
    private val canvasWidth = windowWidth - cellWidth

    private var lwjglAWTCanvas: LwjglAWTCanvas? = null
    private lateinit var sampleList: JList<String>


    init {
        title = GdxSamplerLauncher::class.java.simpleName
        minimumSize = windowSize
        size = windowSize
        isResizable = false
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        createControlPanel()

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                println("windowClosing")
                lwjglAWTCanvas?.stop()
            }
        })

        //launchSample("com.libgdxgametemplate.game.InputPollingSample")

        // Tell window/jframe to resize and layout component
        pack()
        isVisible = true
    }

    private fun createControlPanel() {
        val controlPanel = JPanel(GridBagLayout())
        val c = GridBagConstraints()

        //scrollpane
        c.apply {
            gridx = 0 // Column
            gridy = 0 // row
            fill = GridBagConstraints.VERTICAL // fill vertically
            weighty = 1.0 // used to fill empty space
        }

        sampleList = JList(arrayOf("com.libgdxgametemplate.game.InputPollingSample"))
        sampleList.fixedCellWidth = cellWidth
        sampleList.selectionMode = ListSelectionModel.SINGLE_SELECTION

        // Add double click to launch sample
        sampleList.addMouseListener(object:MouseAdapter() {
            override fun mouseClicked(mouseEvent: MouseEvent?) {
                if(mouseEvent?.clickCount == 2) {
                    launchSelectSample()
                }
            }
        })

        val scrollPane = JScrollPane(sampleList)
        controlPanel.add(scrollPane, c)

        // button
        c.apply {
            gridx = 0 // col
            gridy = 1 // row
            fill = GridBagConstraints.HORIZONTAL
            weighty = 0.0
        }

        val launchButton = JButton("Launch Sample")
        launchButton.addActionListener { launchSelectSample() }

        controlPanel.add(launchButton, c)

        // add to jFrame
        contentPane.add(controlPanel, BorderLayout.WEST)
    }

    private fun launchSelectSample() {
        val sampleName : String? = sampleList.selectedValue

        if (sampleName.isNullOrBlank()) {
            println("sample name is null or blank. Can't launch")
            return
        }

        launchSample(sampleName)
    }

    private fun launchSample(name: String?) {
        println("launching name= $name")

        // Cleanup before running new sample
        lwjglAWTCanvas?.stop()

        if (lwjglAWTCanvas != null) {
            contentPane.remove(lwjglAWTCanvas?.canvas)
        }

        // Get class object by name
        val sampleClass = ClassReflection.forName(name)

        // Create new instance of sample class
        val sample = ClassReflection.newInstance(sampleClass) as ApplicationListener

        lwjglAWTCanvas = LwjglAWTCanvas(sample)
        lwjglAWTCanvas?.canvas?.size = Dimension(canvasWidth, windowHeight)
        contentPane.add(lwjglAWTCanvas?.canvas, BorderLayout.CENTER)
        pack()
    }
}

// == main ==
fun main(args: Array<String>) {
    /*
    SwingUtilities.invokeLater(object : Runnable {
        override fun run() {
            GdxSamplerLauncher()
        }
    })
     */
    SwingUtilities.invokeLater { GdxSamplerLauncher() }

}