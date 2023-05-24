package quickFrame.utils

import quickFrame.components.QForm
import quickFrame.components.QFormsGroup
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
 * Creates a group of forms with the specified number of rows and columns,
 * and allows configuring the group using a DSL-style block.
 *
 * @param rows The number of rows in the group.
 * @param cols The number of columns in the group.
 * @param block The DSL-style block used to configure the group.
 * @return The configured QFormsGroup object.
 */
fun formsGroup(rows: Int, cols: Int, block: QFormsGroup.() -> Unit): QFormsGroup {
    val group = QFormsGroup(rows, cols)
    group.block()
    return group
}
