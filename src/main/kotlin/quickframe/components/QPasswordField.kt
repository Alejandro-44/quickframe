package quickframe.components

import javax.swing.JPasswordField

/**
 * This class represents a customized password field, which inherits from the JPasswordField class.
 * It allows the setting of various properties and actions using a builder.
 */
class QPasswordField: JPasswordField() {

    /**
     * An instance of [QComponentBuilder] to apply properties to this [QPasswordField].
     */
    private val builder = QComponentBuilder()

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QPasswordField].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QPasswordField) -> Unit) {
        builder.block(this)
    }


}