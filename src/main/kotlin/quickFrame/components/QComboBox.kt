package quickFrame.components


import javax.swing.JComboBox

class QComboBox<T>: JComboBox<T>() {

    private val builder = QComponentBuilder()

    fun properties(block: QComponentBuilder.(QComboBox<T>) -> Unit) {
        builder.block(this)
    }

    infix fun items(items: Array<T>) {
        items.forEach { addItem(it) }
    }

    infix fun selectedItem(i: Int) {
        this.selectedItem = i
    }
}