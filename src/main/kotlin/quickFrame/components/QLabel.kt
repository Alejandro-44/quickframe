package quickFrame.components

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
     * Applies a [block] of [QComponentBuilder] properties to this [QLabel].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QLabel) -> Unit) {
        builder.block(this)
    }
}