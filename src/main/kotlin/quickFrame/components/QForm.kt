package quickFrame.components

import java.awt.GridBagLayout
import javax.swing.JPanel

class QForm: JPanel()
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

    fun password(block: QPasswordField.() -> Unit): QPasswordField {
        val input = QPasswordField()
        input.block()
        this.add(input, grid)
        return input
    }

    fun checkbox(block: QCheckBox.() -> Unit): QCheckBox {
        val input = QCheckBox()
        input.block()
        this.add(input, grid)
        return input
    }

    fun radioButton(block: QRadioButton.() -> Unit): QRadioButton {
        val input = QRadioButton()
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

    fun<T> comboBox(block: QComboBox<T>.() -> Unit): QComboBox<T>
    {
        val combo = QComboBox<T>()
        combo.block()
        this.add(combo,grid)

        return combo
    }
}