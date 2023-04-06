package quickFrame.components

import javax.swing.JButton

class QButton(text: String): JButton(text) {

    private val builder = QComponentBuilder(this)

    infix fun content(s: String) {
        this.text = s
    }

    fun properties(block: QComponentBuilder.(QButton) -> Unit) {
        builder.block(this)
    }

    fun onClick(action: () -> Unit) {
        this.addActionListener {
            action()
        }
    }
}