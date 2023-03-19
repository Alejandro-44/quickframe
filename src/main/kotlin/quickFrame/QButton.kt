package quickFrame

import java.awt.event.ActionListener
import javax.swing.JButton

class QButton: JButton() {

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