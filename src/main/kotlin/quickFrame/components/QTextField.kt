package quickFrame.components

import javax.swing.JTextField
/**
 * custom implementation of the JTextField that provides a convenient way to set its properties.
 */
class QTextField: JTextField() {

    /**
     * An instance of [QComponentBuilder] to apply properties to this [QTextField].
     */
    private val builder = QComponentBuilder()

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QTextField].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QTextField) -> Unit) {
        builder.block(this)
    }
}




