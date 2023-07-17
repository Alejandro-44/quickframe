package quickframe.components

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
     * Sets the number of columns for this text field.
     *  @param n number of columns
     */
    infix fun columns(n: Int) {
        this.columns = n
    }

    /**
     * Sets the content (text) of a JTextField.
     *
     * @param text The text content.
     */
    infix fun content(text: String) {
        this.text = text
    }

    /**
     * Sets whether this component is editable or non-editable.
     * @param b set if is editable or not
     */
    infix fun editable(b: Boolean) {
        this.isEditable = b
    }

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QTextField].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QTextField) -> Unit) {
        builder.block(this)
    }
}




