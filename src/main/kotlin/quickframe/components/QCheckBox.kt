package quickframe.components

import javax.swing.JCheckBox

/**
 * This class represents a customized checkbox, which inherits from the JCheckBox class.
 * It allows the setting of various properties and actions using a builder.
 */
class QCheckBox: JCheckBox() {

    /**
     * An instance of [QComponentBuilder] to apply properties to this [QCheckBox].
     */
    private val builder = QComponentBuilder()

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QCheckBox].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QCheckBox) -> Unit) {
        builder.block(this)
    }

}