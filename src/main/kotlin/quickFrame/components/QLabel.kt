package quickFrame.components

import jdk.incubator.vector.VectorOperators.Test
import javax.swing.ImageIcon
import javax.swing.JLabel

/**
 * This class represents a customized label, which inherits from the JLabel class.
 * It allows the setting of various properties and actions using a builder.
 * @param text the text to display on the label
 */
class QLabel(text: String): JLabel(text) {
    /**
     * An instance of [QComponentBuilder] to apply properties to this [QLabel].
     */
    private val builder = QComponentBuilder()

    /**
     * Sets the content (text) of a JTextField.
     *
     * @param text The text content.
     */
    infix fun text(text: String) {
        this.text = text
    }

    /**
     * Sets the horizontal alignment of the text of this label.
     *  @param op an option from JLabel constants
     */
    infix fun aligntext(op: Int) {
        this.horizontalAlignment = op
    }

    /**
     * Sets the horizontal alignment of the text of this label.
     *  @param op an option from JLabel constants
     */
    infix fun icon(url: String) {
        this.icon = ImageIcon(url)
    }

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QLabel].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QLabel) -> Unit) {
        builder.block(this)
    }
}