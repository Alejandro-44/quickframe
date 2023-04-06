package quickFrame.components

import javax.swing.JPasswordField

class QPasswordField: JPasswordField() {

    private val builder = QComponentBuilder()

    fun properties(block: QComponentBuilder.(QPasswordField) -> Unit) {
        builder.block(this)
    }


}