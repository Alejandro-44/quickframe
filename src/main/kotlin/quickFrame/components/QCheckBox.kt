package quickFrame.components

import javax.swing.Icon
import javax.swing.JCheckBox

class QCheckBox: JCheckBox() {

    private val builder = QComponentBuilder()

    fun properties(block: QComponentBuilder.(QCheckBox) -> Unit) {
        builder.block(this)
    }

}