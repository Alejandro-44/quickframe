package quickFrame.components

import javax.swing.JTextField

class QTextField: JTextField() {

    private val builder = QComponentBuilder(this)

    fun properties(block: QComponentBuilder.(QTextField) -> Unit) {
        builder.block(this)
    }

    infix fun columns(n: Int) {
        this.columns = n
    }
}