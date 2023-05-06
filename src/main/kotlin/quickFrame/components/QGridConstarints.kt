package quickFrame.components

import java.awt.GridBagConstraints
import java.awt.Insets
import java.awt.Point

class QGridConstarints: GridBagConstraints() {

    infix fun posX(p: Int) {
        this.gridx = p
    }

    infix fun posY(p: Int) {
        this.gridy = p
    }

    infix fun spanX(n: Int) {
        this.gridwidth = n
    }

    infix fun spanY(n: Int) {
        this.gridheight = n
    }

    infix fun paddingX(n: Int) {
        this.ipadx = n
    }

    infix fun paddingY(n: Int) {
        this.ipady = n
    }

    infix fun fill(fillType: Int) {
        this.fill = fillType
    }

    infix fun margin(i: Insets) {
        this.insets = i
    }

    infix fun anchor(n: Int) {
        this.anchor = n
    }

    infix fun weightX(d: Double) {
        this.weightx = d
    }

    infix fun weightY(d: Double) {
        this.weighty = d
    }

    infix fun position(p: Point) {
        this.gridx = p.x
        this.gridy = p.y
    }

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