package quickFrame.components

import javax.swing.JButton

/**
 * This class represents a customized button, which inherits from the JButton class.
 * It allows the setting of various properties and actions using a builder.
 * @param text the text to display on the button
*/
class QButton(text: String): JButton(text) {

    /**
     * An instance of [QComponentBuilder] to apply properties to this [QButton].
     */
    private val builder = QComponentBuilder()

    /**
     * Sets the text of the button.
     * @param s the text to set
     */
    infix fun content(s: String) {
        this.text = s
    }

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QButton].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QButton) -> Unit) {
        builder.block(this)
    }

    /**
     * Sets an action to be performed when the button is clicked.
     * @param action a lambda expression that defines the action to be performed when the button is clicked.
     */
    fun onClick(action: () -> Unit) {
        this.addActionListener {
            action()
        }
    }
}