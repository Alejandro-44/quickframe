package quickFrame.components


import javax.swing.JComboBox

class QComboBox<T>: JComboBox<T>() {

    private val builder = QComponentBuilder(this)

    fun properties(block: QComponentBuilder.(QComboBox<T>) -> Unit) {
        builder.block(this)
    }

    infix fun items(items: Array<T>) {
        for (item in items) {
            addItem(item)
        }
    }

    infix fun selectedItem(i: Int) {
        this.selectedItem = i
    }
}