package quickFrame.components

import javax.swing.JTextField

class QTextField: JTextField() {

    private val builder = QComponentBuilder()

    fun properties(block: QComponentBuilder.(QTextField) -> Unit) {
        builder.block(this)
    }


}