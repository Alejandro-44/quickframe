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
import javax.swing.border.Border

/**
 * QComponentBuilder is a utility class that provides infix methods to set properties to Swing components.
 * These properties include:
 *  * background color
 *  * font family
 *  * foreground color
 *  * size
 *  * preferred size
 *  * maximum size
 *  * minimum size
 *  * layout manager
 *  * enabled status
 *  * visibility
 *  * line border color
 *  * text alignment
 *  * number of columns for a JTextField
 *  * icon and text for a JRadioButton,
 *  * selected status for a JRadioButton.
 * @author Alejandro Argüello
 * @version 0.1
 * @since 11/04/2023
 */
class QComponentBuilder {
    val center = JLabel.CENTER
    val right = JLabel.RIGHT
    val left = JLabel.LEFT

    private var currentBorder: Border? = null
    /**
     * Sets the background color of this component.
     * @param bg background color (awt.Color)
     */
    infix fun JComponent.background(bg: Color) {
        this.background = bg
    }

    /**
     * Sets the font family for this component.
     * @param font (awt.Font)
     */
    infix fun JComponent.fontFamily(font: Font) {
        this.font = font
    }

    /**
     * Sets the foreground (text) color of this component.
     * @param foreground text color (awt.Color)
     */
    infix fun JComponent.color(foreground: Color) {
        this.foreground = foreground
    }

    /**
     * Sets the size of this component.
     * @param d width and height in an awt.Dimension class
     */
    infix fun JComponent.size(d: Dimension) {
        this.size = d
    }

    /**
     * Sets the preferred size of this component.
     * @param d width and height in an awt.Dimension class
     */
    infix fun JComponent.preferredSize(d: Dimension) {
        this.preferredSize = d
    }

    /**
     * Sets the maximum size of this component.
     * @param d width and height in an awt.Dimension class
     */
    infix fun JComponent.maxSize(d: Dimension) {
        this.maximumSize = d
    }

    /**
     * Sets the minimum size of this component.
     * @param d width and height in an awt.Dimension class
     */
    infix fun JComponent.minsize(d: Dimension) {
        this.minimumSize = d
    }

    /**
     * Sets the layout manager for this component.
     * @param l layout manager
     */
    infix fun JComponent.layout(l: LayoutManager) {
        this.layout = l
    }

    /**
     * Sets whether this component is enabled or disabled.
     * @param b set if is enabled or not
     */
    infix fun JComponent.enabled(b: Boolean) {
        this.isEnabled = b
    }

    /**
     * Sets whether this component is visible or hidden.
     * @param b set if is visible or not
     */
    infix fun JComponent.visible(b: Boolean) {
        this.isVisible = b
    }

    /**
     * Sets a line border with the given color around this component.
     *  @param color color for border awt.Color
     */
    infix fun JComponent.lineBorder(color: Color) {
        currentBorder = BorderFactory.createLineBorder(color)
        this.border = currentBorder
    }

    /**
     * Sets a titled border with the given string for its title.
     *  @param s tile string
     */
    infix fun JComponent.titledBorder(s: String) {
        this.border = BorderFactory.createTitledBorder(currentBorder,s)
    }

    /**
     * Sets the horizontal alignment of the text of this label.
     *  @param op an option from JLabel constants
     */
    infix fun JLabel.aligntext(op: Int) {
        this.horizontalAlignment = op
    }

    /**
     * Sets the number of columns for this text field.
     *  @param n number of columns
     */
    infix fun JTextField.columns(n: Int) {
        this.columns = n
    }

    /**
     * Sets the text of this radio button.
     *  @param s text for radio button
     */
    infix fun JRadioButton.text(s: String) {
        this.text = s
    }

    /**
     * Sets the icon of this radio button.
     * @param i icon for radio button
     */
    infix fun JRadioButton.icon(i: Icon) {
        this.icon = i
    }

    /**
     * Sets whether this radio button is selected or not.
     * @param b
     */
    infix fun JRadioButton.selected(b: Boolean) {
        this.isSelected = b
    }
}
