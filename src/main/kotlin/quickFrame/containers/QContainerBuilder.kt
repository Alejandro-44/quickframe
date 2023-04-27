package quickFrame.containers

import java.awt.Dimension
import java.awt.LayoutManager
import java.awt.Point
import javax.swing.JFrame
import javax.swing.WindowConstants

class QContainerBuilder {
    val EXIT = WindowConstants.EXIT_ON_CLOSE
    val DISPOSE = WindowConstants.DISPOSE_ON_CLOSE
    val NOTHING = WindowConstants.DO_NOTHING_ON_CLOSE
    val HIDE = WindowConstants.HIDE_ON_CLOSE

    infix fun JFrame.title(text: String) {
        this.title = text
    }
    infix fun JFrame.size(d: Dimension) {
        this.size = d
    }

    infix fun JFrame.layout(l: LayoutManager) {
        this.layout = l
    }

    infix fun JFrame.visible(b: Boolean) {
        this.isVisible = b
    }

    infix fun JFrame.onClose(action: Int) {
        this.defaultCloseOperation = action
    }
    infix fun JFrame.resizable(b: Boolean) {
        this.isResizable = b
    }

    infix fun JFrame.location(p: Point) {
        this.location = p
    }
}