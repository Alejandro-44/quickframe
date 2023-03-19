package quickFrame

fun buildFrame(build: QFrame.() -> Unit): QFrame {
    val frame = QFrame()
    frame.build()
    return frame
}

fun buildForm(rows: Int, cols: Int, hgap: Int=0, vgap: Int=0,build: QForm.() -> Unit): QForm {
    val form = QForm(rows, cols, hgap, vgap)
    form.build()
    return form
}