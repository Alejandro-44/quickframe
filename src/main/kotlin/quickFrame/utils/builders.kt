package quickFrame.utils

import quickFrame.components.QForm
import quickFrame.containers.QFrame

/**
 * Creates and returns a QFrame instance with the specified build instructions.
 * @param build A lambda expression that takes a [QFrame] instance as its receiver and returns [Unit].
 *  This lambda is used to configure the properties of the [QFrame].
 *  @return A new [QFrame] instance with the specified properties.
 */
fun buildFrame(build: QFrame.() -> Unit): QFrame {
    val frame = QFrame()
    frame.build()
    return frame
}

/**
 * Creates and returns a QForm instance with the specified build instructions.
 * @param build A lambda expression that takes a [QForm] instance as its receiver and returns [Unit].
 *   This lambda is used to configure the properties of the [QForm].
 * @return @return A new [QForm] instance with the specified properties.
 */
fun buildForm(build: QForm.() -> Unit): QForm {
    val form = QForm()
    form.build()
    return form
}