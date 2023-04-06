package quickFrame.utils

import quickFrame.components.QForm
import quickFrame.containers.QFrame

fun buildFrame(build: QFrame.() -> Unit): QFrame {
    val frame = QFrame()
    frame.build()
    return frame
}

fun buildForm(build: QForm.() -> Unit): QForm {
    val form = QForm()
    form.build()
    return form
}