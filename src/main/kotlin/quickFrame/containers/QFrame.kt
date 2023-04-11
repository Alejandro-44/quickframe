package quickFrame.containers

import java.awt.BorderLayout
import java.awt.Component
import javax.swing.JFrame

class QFrame: JFrame() {

    private val builder = QContainerBuilder()

    fun properties(block: QContainerBuilder.(QFrame) -> Unit) {
        builder.block(this)
    }

    infix fun addToCenter(component: Component) {
        add(component, BorderLayout.CENTER)
    }

    infix fun addToRight(component: Component) {
        add(component, BorderLayout.WEST)
    }

    infix fun addToLeft(component: Component) {
        add(component, BorderLayout.EAST)
    }

    infix fun addToBottom(component: Component) {
        add(component, BorderLayout.SOUTH)
    }
}