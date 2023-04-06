package quickFrame.components

import javax.swing.Icon
import javax.swing.JRadioButton

class QRadioButton: JRadioButton() {
    private val builder = QComponentBuilder()

    fun properties(block: QComponentBuilder.(QRadioButton) -> Unit) {
        builder.block(this)
    }


}