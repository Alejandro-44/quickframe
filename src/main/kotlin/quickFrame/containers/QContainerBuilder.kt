package quickFrame.containers

import java.awt.Dimension
import java.awt.LayoutManager
import javax.swing.JFrame
import javax.swing.WindowConstants

class QContainerBuilder constructor (private val container: JFrame) {
    val EXIT = WindowConstants.EXIT_ON_CLOSE
    val DISPOSE = WindowConstants.DISPOSE_ON_CLOSE
    val NOTHING = WindowConstants.DO_NOTHING_ON_CLOSE
    val HIDE = WindowConstants.HIDE_ON_CLOSE

    infix fun JFrame.title(text: String) {
        container.title = text
    }
    infix fun JFrame.size(d: Dimension) {
        container.size = d
    }

    infix fun JFrame.layout(l: LayoutManager) {
        container.layout = l
    }

    infix fun JFrame.visible(b: Boolean) {
        container.isVisible = b
    }

    infix fun JFrame.onClose(action: Int) {
        container.defaultCloseOperation = action
    }
    infix fun JFrame.resizable(b: Boolean) {
        container.isResizable = b
    }
}