package quickFrame

import java.awt.GridBagConstraints
import java.awt.Insets

class QGridConstarints: GridBagConstraints() {

    infix fun posx(p: Int) {
        this.gridx = p
    }

    infix fun posy(p: Int) {
        this.gridy = p
    }

    infix fun spanx(n: Int) {
        this.gridwidth = n
    }

    infix fun spanxy(n: Int) {
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

    infix fun span(n: Int) {
        this.anchor = n
    }

    infix fun weightx(d: Double) {
        this.weightx = d
    }

    infix fun weighty(d: Double) {
        this.weighty = d
    }
}