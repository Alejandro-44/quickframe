package quickframe.containers

import java.awt.BorderLayout
import java.awt.Component
import javax.swing.JFrame

/**
 * QFrame class represents a customized JFrame container that uses the BorderLayout as its default layout.
 * It allows the user to set properties for the frame, and add components to its different regions: center, right, left, and bottom.
 */
class QFrame: JFrame() {

    private val builder = QContainerBuilder()

    /**
     * Applies a [block] of [QContainerBuilder] properties to this [QFrame].
     * @param block a lambda expression with a receiver of type [QContainerBuilder].
     */
    fun properties(block: QContainerBuilder.(QFrame) -> Unit) {
        builder.block(this)
    }

    /**
     * Adds a component to the center region of the QFrame.
     * @param component The component to be added to the center region.
     */
    infix fun addToCenter(component: Component) {
        add(component, BorderLayout.CENTER)
    }

    /**
     * Adds a component to the right region of the QFrame.
     * @param component The component to be added to the right region.
     */
    infix fun addToRight(component: Component) {
        add(component, BorderLayout.WEST)
    }

    /**
     * Adds a component to the left region of the QFrame.
     * @param component The component to be added to the left region.
     */
    infix fun addToLeft(component: Component) {
        add(component, BorderLayout.EAST)
    }

    /**
     * Adds a component to the bottom region of the QFrame.
     * @param component The component to be added to the bottom region.
     */
    infix fun addToBottom(component: Component) {
        add(component, BorderLayout.SOUTH)
    }

    /**
     * Adds a component to the top region of the QFrame.
     * @param component The component to be added to the top region.
     */
    infix fun addToTop(component: Component) {
        add(component, BorderLayout.NORTH)
    }
}