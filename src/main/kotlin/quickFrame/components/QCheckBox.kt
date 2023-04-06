package quickFrame.components

import javax.swing.Icon
import javax.swing.JCheckBox

class QCheckBox: JCheckBox() {

    private val builder = QComponentBuilder(this)

    fun properties(block: QComponentBuilder.(QCheckBox) -> Unit) {
        builder.block(this)
    }

    infix fun text(s: String) {
        this.text = s
    }

    infix fun icon(i: Icon) {
        this.icon = i
    }

    infix fun selected(b: Boolean) {
        this.isSelected = b
    }
}