package quickFrame.components

import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.LayoutManager
import javax.swing.BorderFactory
import javax.swing.Icon
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JRadioButton
import javax.swing.JTextField

class QComponentBuilder {
    val center = JLabel.CENTER
    val right = JLabel.RIGHT
    val left = JLabel.LEFT

    /*
    * General properties
    * */
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

    infix fun JComponent.preferredSize(d: Dimension) {
        this.preferredSize = d
    }

    infix fun JComponent.maxSize(d: Dimension) {
        this.maximumSize = d
    }

    infix fun JComponent.minsize(d: Dimension) {
        this.minimumSize = d
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

    infix fun JComponent.lineBorder(color: Color) {
        this.border = BorderFactory.createLineBorder(color)
    }

    infix fun JLabel.aligntext(op: Int) {
        this.horizontalAlignment = op
    }

    infix fun JTextField.columns(n: Int) {
        this.columns = n
    }

    infix fun JRadioButton.text(s: String) {
        this.text = s
    }

    infix fun JRadioButton.icon(i: Icon) {
        this.icon = i
    }

    infix fun JRadioButton.selected(b: Boolean) {
        this.isSelected = b
    }
}