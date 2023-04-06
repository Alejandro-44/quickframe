package quickFrame.components

import javax.swing.JPasswordField

class QPasswordField: JPasswordField() {

    private val builder = QComponentBuilder(this)

    fun properties(block: QComponentBuilder.(QPasswordField) -> Unit) {
        builder.block(this)
    }

    infix fun columns(n: Int) {
        this.columns = n
    }
}