package quickFrame.components

import javax.swing.JLabel

class QLabel(text: String): JLabel(text) {

    private val builder = QComponentBuilder()

    fun properties(block: QComponentBuilder.(QLabel) -> Unit) {
        builder.block(this)
    }

    infix fun aligntext(op: Int) {
        this.horizontalAlignment = op
    }
}