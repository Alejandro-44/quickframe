package quickFrame.containers

import java.awt.BorderLayout
import java.awt.Component
import javax.swing.JFrame

class QFrame: JFrame() {

    private val builder = QContainerBuilder(this)

    fun properties(block: QContainerBuilder.(QFrame) -> Unit) {
        builder.block(this)
    }

    infix fun addToCenter(component: Component) {
        add(component, BorderLayout.CENTER)
    }
}