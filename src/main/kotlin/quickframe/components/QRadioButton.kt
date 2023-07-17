package quickframe.components

import javax.swing.JRadioButton

/**
 * This class represents a customized radio button, which inherits from the JRadioButton class.
 * It allows the setting of various properties and actions using a builder.
 */
class QRadioButton: JRadioButton() {
    /**
     * An instance of [QComponentBuilder] to apply properties to this [QRadioButton].
     */
    private val builder = QComponentBuilder()

    /**
     * Sets whether this radio button is selected or not.
     * @param b
     */
    infix fun selected(b: Boolean) {
        this.isSelected = b
    }

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QRadioButton].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QRadioButton) -> Unit) {
        builder.block(this)
    }
}