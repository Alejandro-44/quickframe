package quickframe.utils

import quickframe.components.QForm
import quickframe.components.QFormsGroup
import quickframe.containers.QFrame

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

/**
 * Creates a template for building a QForm by returning a lambda function.
 * Use to create reusable instance of [QForm]
 *
 * @param build The lambda function that configures the QForm.
 * @return The lambda function that configures the QForm.
 */
fun buildTemplate(build: QForm.() -> Unit): QForm.() -> Unit {
    return build
}

/**
 * Creates a group of forms with the specified number of rows and columns, as well as horizontal and vertical gaps,
 * and allows configuring the group using a DSL-style block.
 *
 * @param rows The number of rows in the group. Default is 1.
 * @param cols The number of columns in the group. Default is 1.
 * @param hgap The horizontal gap between components in the group. Default is 0.
 * @param vgap The vertical gap between components in the group. Default is 0.
 * @param block The DSL-style block used to configure the group.
 * @return The configured QFormsGroup object.
 */
fun formsGroup(
    rows: Int = 1,
    cols: Int = 1,
    hgap: Int = 0,
    vgap: Int = 0,
    block: QFormsGroup.() -> Unit
): QFormsGroup {
    val group = QFormsGroup(rows, cols, hgap, vgap)
    group.block()
    return group
}

