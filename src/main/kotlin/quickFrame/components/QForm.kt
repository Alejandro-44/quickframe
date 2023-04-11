package quickFrame.components

import java.awt.GridBagLayout
import javax.swing.JPanel

/**
 * QForm is a subclass of JPanel and provides a layout for creating forms using GridBagLayout.
 *
 * It also provides several convenience methods for adding form elements such as QLabel, QTextField, QPasswordField,
 * QCheckBox, QRadioButton, QButton and QComboBox to the form with a single line of code.
 */
class QForm: JPanel()
{
    /**
     * Constructs a new QForm object and sets its layout to GridBagLayout.
     */
    init {
        layout = GridBagLayout()
    }

    /**
     *The QComponentBuilder instance used to configure the properties of the form and its components.
     */
    private val builder = QComponentBuilder()
    /**
     * The QGridConstarints instance used to specify the position and size of components in the form.
     */
    val grid = QGridConstarints()

    /**
     * Configures the properties of the form and its components using the QComponentBuilder instance.
     * @param block a function that takes a QComponentBuilder instance and a QForm instance and applies the configuration.
     */
    fun properties(block: QComponentBuilder.(QForm) -> Unit)
    {
        builder.block(this)
    }

    /**
     * Adds a QLabel to the form with the specified text and applies the specified configuration.
     * @param text the text to display on the label.
     * @param block a function that takes a QLabel instance and applies the configuration.
     * @return the created QLabel object.
     */
    fun label(text: String, block: QLabel.() -> Unit): QLabel
    {
        val lab = QLabel(text)
        lab.block()
        this.add(lab, grid)
        return lab
    }



    /**
     * Adds a QTextField to the form and applies the specified configuration.
     * @param block a function that takes a QTextField instance and applies the configuration.
     * @return the created QTextField object.
     */
    fun textInput( block: QTextField.() -> Unit) : QTextField
    {
        val input = QTextField()
        input.block()
        this.add(input, grid)
        return input
    }

    /**
     * Adds a QPasswordField to the form and applies the specified configuration.
     * @param block a function that takes a QPasswordField instance and applies the configuration.
     * @return the created QPasswordField object.
     */
    fun password(block: QPasswordField.() -> Unit): QPasswordField {
        val input = QPasswordField()
        input.block()
        this.add(input, grid)
        return input
    }

    /**
     * Adds a QCheckBox to the form and applies the specified configuration.
     * @param block a function that takes a QCheckBox instance and applies the configuration.
     * @return the created QCheckBox object.
     */
    fun checkbox(block: QCheckBox.() -> Unit): QCheckBox {
        val input = QCheckBox()
        input.block()
        this.add(input, grid)
        return input
    }

    /**
     * Adds a QRadioButton to the form and applies the specified configuration.
     * @param block a function that takes a QRadioButton instance and applies the configuration.
     * @return the created QRadioButton object.
     */
    fun radioButton(block: QRadioButton.() -> Unit): QRadioButton {
        val input = QRadioButton()
        input.block()
        this.add(input, grid)
        return input
    }

    /**
     * Adds a QButton to the form with the specified text and applies the specified configuration.
     * @param text the text to display on the button.
     * @param block a function that takes a QButton instance and applies the configuration.
     */
    fun button(text: String,block: QButton.() -> Unit)
    {
        val btn = QButton(text)
        btn.block()
        this.add(btn,grid)
    }

    /**
     * Creates and adds a new instance of QComboBox to the QForm panel, and applies the properties defined in the given
     * block to the component. The QComboBox allows users to select one item from a dropdown list.
     * @param block a lambda expression that sets the properties of the QComboBox using a QComboBox builder object.
     * @return the newly created and added QComboBox instance.
     */
    fun<T> comboBox(block: QComboBox<T>.() -> Unit): QComboBox<T>
    {
        val combo = QComboBox<T>()
        combo.block()
        this.add(combo,grid)

        return combo
    }
}