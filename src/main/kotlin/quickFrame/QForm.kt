package quickFrame

import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.GridLayout
import javax.swing.JPanel

class QForm(): JPanel()
{
    init {
        layout = GridBagLayout()
    }

    private val builder = QComponentBuilder(this)
    val grid = QGridConstarints()

    fun properties(block: QComponentBuilder.(QForm) -> Unit)
    {
        builder.block(this)
    }

    fun label(text: String, block: QLabel.() -> Unit): QLabel
    {
        val lab = QLabel(text)
        lab.block()
        this.add(lab, grid)
        return lab
    }

    fun textInput( block: QTextField.() -> Unit) : QTextField
    {
        val input = QTextField()
        input.block()
        this.add(input, grid)
        return input
    }

    fun button(text: String,block: QButton.() -> Unit)
    {
        val btn = QButton(text)
        btn.block()
        this.add(btn,grid)
    }
}