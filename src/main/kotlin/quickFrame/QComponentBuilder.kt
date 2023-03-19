package quickFrame

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.LayoutManager
import javax.swing.JComponent
import javax.swing.JLabel

class QComponentBuilder constructor (private val component: JComponent) {
    val center = JLabel.CENTER
    val right = JLabel.RIGHT
    val left = JLabel.LEFT

    infix fun JComponent.background(bg: Color) {
        component.background = bg
    }

    infix fun JComponent.fontFamily(font: Font) {
        component.font = font
    }

    infix fun JComponent.color(foreground: Color) {
        component.foreground = foreground
    }

    infix fun JComponent.size(d: Dimension) {
        component.size = d
    }

    infix fun JComponent.layout(l: LayoutManager) {
        component.layout = l
    }

    infix fun JComponent.enabled(b: Boolean) {
        component.isEnabled = b
    }

    infix fun JComponent.visible(b: Boolean) {
        component.isVisible = b
    }

}