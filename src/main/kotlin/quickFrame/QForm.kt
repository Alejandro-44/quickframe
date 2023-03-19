package quickFrame

import java.awt.GridLayout
import javax.swing.JPanel

class QForm(rows: Int, cols: Int, hgap: Int, vgap: Int): JPanel()
{
    init {
        layout = GridLayout(rows, cols, hgap, vgap)
    }

    private val builder = QComponentBuilder(this)

    fun properties(block: QComponentBuilder.(QForm) -> Unit)
    {
        builder.block(this)
    }

    fun label(text: String, block: QLabel.() -> Unit = {}): QLabel
    {
        val lab = QLabel(text)
        lab.block()
        this.add(lab)
        return lab
    }

    fun inputTxt( block: QTextField.() -> Unit = {}) : QTextField
    {
        val input = QTextField()
        input.block()
        this.add(input)
        return input
    }

    fun button(block: QButton.() -> Unit)
    {
        val btn = QButton()
        btn.block()
        this.add(btn)
    }
}