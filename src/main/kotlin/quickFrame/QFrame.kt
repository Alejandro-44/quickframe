package quickFrame

import java.awt.BorderLayout
import java.awt.Component
import javax.swing.JFrame

class QFrame: JFrame() {

    private val builder = QFrameBuilder(this)

    fun properties(block: QFrameBuilder.(QFrame) -> Unit) {
        builder.block(this)
    }

    infix fun addToCenter(component: Component) {
        add(component, BorderLayout.CENTER)
    }
}