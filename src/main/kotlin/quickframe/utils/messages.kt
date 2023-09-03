package quickframe.utils

import java.awt.Component
import javax.swing.JOptionPane

/**
 * Displays an error dialog with an optional title.
 *
 * @param parentComponent The parent component where the dialog will be displayed, or null if not provided.
 * @param message The error message to be shown in the dialog.
 * @param title The optional title for the error dialog.
 */
fun errorMessage(parentComponent: Component?, message: String, title: String="") {
    JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.ERROR_MESSAGE)
}

/**
 * Displays a warning dialog with an optional title.
 *
 * @param parentComponent The parent component where the dialog will be displayed, or null if not provided.
 * @param message The warning message to be shown in the dialog.
 * @param title The optional title for the warning dialog.
 */
fun warningMessage(parentComponent: Component?, message: String, title: String="") {
    JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.WARNING_MESSAGE)
}

/**
 * Displays an information dialog with an optional title.
 *
 * @param parentComponent The parent component where the dialog will be displayed, or null if not provided.
 * @param message The information message to be shown in the dialog.
 * @param title The optional title for the information dialog.
 */
fun informationMessage(parentComponent: Component?, message: String, title: String="") {
    JOptionPane.showMessageDialog(parentComponent, message, title, JOptionPane.INFORMATION_MESSAGE)
}

/**
 * Displays an input dialog with an optional message and returns the user's input as a string.
 *
 * @param parentComponent The parent component where the dialog will be displayed, or null if not provided.
 * @param message The optional message to be shown in the input dialog.
 * @return The user's input as a string, or null if the user cancels the input dialog.
 */
fun inputMessage(parentComponent: Component?=null, message: String=""): String {
    return JOptionPane.showInputDialog(parentComponent, message)
}