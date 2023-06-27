package quickframe.containers;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * The QContainerBuilder class provides methods for building and configuring a JFrame container.
 */
class QContainerBuilder {
    // Constants for window close operation
    val EXIT = WindowConstants.EXIT_ON_CLOSE;
    val DISPOSE = WindowConstants.DISPOSE_ON_CLOSE;
    val NOTHING = WindowConstants.DO_NOTHING_ON_CLOSE;
    val HIDE = WindowConstants.HIDE_ON_CLOSE;

    /**
     * Sets the title of the JFrame.
     *
     * @param text The title text.
     */
    infix fun JFrame.title(text: String) {
        this.title = text
    }

    /**
     * Sets the size of the JFrame.
     *
     * @param d The size as a Dimension object.
     */
    infix fun JFrame.size(d: Dimension) {
        this.size = d
    }

    /**
     * Sets the layout manager for the JFrame.
     *
     * @param l The LayoutManager object.
     */
    infix fun JFrame.layout(l: LayoutManager) {
        this.layout = l
    }

    /**
     * Sets the visibility of the JFrame.
     *
     * @param b The visibility flag.
     */
    infix fun JFrame.visible(b: Boolean) {
        this.isVisible = b
    }

    /**
     * Sets the default close operation for the JFrame.
     *
     * @param action The close operation constant.
     */
    infix fun JFrame.onClose(action: Int) {
        this.defaultCloseOperation = action
    }

    /**
     * Sets whether the JFrame is resizable or not.
     *
     * @param b The resizable flag.
     */
    infix fun JFrame.resizable(b: Boolean) {
        this.isResizable = b
    }

    /**
     * Sets the location of the JFrame.
     *
     * @param p The location as a Point object.
     */
    infix fun JFrame.location(p: Point) {
        this.location = p
    }

    /**
     * Sets the icon image of the JFrame.
     *
     * @param url The URL of the image.
     */
    infix fun JFrame.icon(url: String) {
        this.iconImage = ImageIcon(url).image
    }
}
