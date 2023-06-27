package quickframe.components


import javax.swing.JComboBox

/**
 * This class represents a customized combo box, which inherits from the JComboBox class.
 * It allows the setting of various properties and actions using a builder.
 */
class QComboBox<T>: JComboBox<T>() {

    /**
     * An instance of [QComponentBuilder] to apply properties to this [QComboBox].
     */
    private val builder = QComponentBuilder()

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QComboBox].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QComboBox<T>) -> Unit) {
        builder.block(this)
    }

    /**
     * Set the items of the QComboBox instance with an array of items.
     *
     * @param items the array of items to set.
     */
    infix fun items(items: Array<T>) {
        items.forEach { addItem(it) }
    }

    /**
     * Set the selected item of the QComboBox instance to the item at the specified index.
     *
     * @param i the index of the item to select.
     */
    infix fun selectedItem(i: Int) {
        this.selectedItem = i
    }

}