package quickframe.utils

import java.awt.Component
import javax.swing.JOptionPane

fun errorMessage(parentComponent: Component?, message: String, title: String="") {
    JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.ERROR_MESSAGE)
}

fun warningMessage(parentComponent: Component?, message: String, title: String="") {
    JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.WARNING_MESSAGE)
}

fun informationMessage(parentComponent: Component?, message: String, title: String="") {
    JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.INFORMATION_MESSAGE)
}

fun inputMessage(parentComponent: Component?=null, message: String=""): String {
    return JOptionPane.showInputDialog(parentComponent, message)
}