package quickFrame.components

import java.awt.GridBagConstraints
import java.awt.Insets
import java.awt.Point

/**
 * The QGridConstarints class extends GridBagConstraints and provides additional methods for setting grid constraints easily.
 */
class QGridConstarints : GridBagConstraints() {

    /**
     * Sets the X position of the component in the grid.
     *
     * @param p The X position.
     */
    infix fun posX(p: Int) {
        this.gridx = p
    }

    /**
     * Sets the Y position of the component in the grid.
     *
     * @param p The Y position.
     */
    infix fun posY(p: Int) {
        this.gridy = p
    }

    /**
     * Sets the number of cells the component will span horizontally.
     *
     * @param n The number of cells to span.
     */
    infix fun spanX(n: Int) {
        this.gridwidth = n
    }

    /**
     * Sets the number of cells the component will span vertically.
     *
     * @param n The number of cells to span.
     */
    infix fun spanY(n: Int) {
        this.gridheight = n
    }

    /**
     * Sets the padding of the component in the X direction.
     *
     * @param n The padding value.
     */
    infix fun paddingX(n: Int) {
        this.ipadx = n
    }

    /**
     * Sets the padding of the component in the Y direction.
     *
     * @param n The padding value.
     */
    infix fun paddingY(n: Int) {
        this.ipady = n
    }

    /**
     * Sets the fill type for the component.
     *
     * @param fillType The fill type.
     */
    infix fun fill(fillType: Int) {
        this.fill = fillType
    }

    /**
     * Sets the margins of the component using Insets.
     *
     * @param i The Insets object representing the margins.
     */
    infix fun margin(i: Insets) {
        this.insets = i
    }

    /**
     * Sets the anchor for the component.
     *
     * @param n The anchor value.
     */
    infix fun anchor(n: Int) {
        this.anchor = n
    }

    /**
     * Sets the weight in the X direction for the component.
     *
     * @param d The weight value.
     */
    infix fun weightX(d: Double) {
        this.weightx = d
    }

    /**
     * Sets the weight in the Y direction for the component.
     *
     * @param d The weight value.
     */
    infix fun weightY(d: Double) {
        this.weighty = d
    }

    /**
     * Sets the position of the component using a Point object.
     *
     * @param p The Point object representing the position.
     */
    infix fun position(p: Point) {
        this.gridx = p.x
        this.gridy = p.y
    }

    /**
     * Resets the grid constraints to their default values.
     */
    fun clean() {
        this.gridx = RELATIVE
        this.gridy = RELATIVE
        this.gridheight = 1
        this.gridwidth = 1
        this.fill = NONE
        this.anchor = CENTER
        this.ipady = 0
        this.ipadx = 0
        this.weightx = 0.0
        this.weighty = 0.0
        this.insets = Insets(0,0,0,0)
    }
}
