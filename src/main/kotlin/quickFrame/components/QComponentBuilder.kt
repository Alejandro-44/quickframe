package quickFrame.components

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.LayoutManager
import javax.swing.JComponent
import javax.swing.JLabel

class QComponentBuilder constructor () {
    val center = JLabel.CENTER
    val right = JLabel.RIGHT
    val left = JLabel.LEFT

    infix fun JComponent.background(bg: Color) {
        this.background = bg
    }

    infix fun JComponent.fontFamily(font: Font) {
        this.font = font
    }

    infix fun JComponent.color(foreground: Color) {
        this.foreground = foreground
    }

    infix fun JComponent.size(d: Dimension) {
        this.size = d
    }

    infix fun JComponent.layout(l: LayoutManager) {
        this.layout = l
    }

    infix fun JComponent.enabled(b: Boolean) {
        this.isEnabled = b
    }

    infix fun JComponent.visible(b: Boolean) {
        this.isVisible = b
    }

}