package quickFrame.components

import java.awt.GridBagLayout
import javax.swing.*

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
    init
    {
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
    private val labels = mutableMapOf<String, JLabel>()
    private val inputs = mutableMapOf<String, JTextField>()
    private val passwords = mutableMapOf<String, JPasswordField>()
    private val buttons = mutableMapOf<String, JButton>()
    private val checkButtons = mutableMapOf<String, JCheckBox>()
    private val radioButtons = mutableMapOf<String, JRadioButton>()

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
    fun label(id: String, text: String, block: QLabel.() -> Unit)
    {
        require(id !in labels) {"id \"$id\" already used"}
        val lab = QLabel(text)
        lab.name = id
        labels[lab.name] = lab
        grid.clean()
        lab.block()
        this.add(lab, grid)
    }



    /**
     * Adds a QTextField to the form and applies the specified configuration.
     * @param block a function that takes a QTextField instance and applies the configuration.
     * @return the created QTextField object.
     */
    fun textInput(id: String, block: QTextField.() -> Unit)
    {
        require(id !in inputs) {"id \"$id\" already used"}
        val input = QTextField()
        input.name = id
        grid.clean()
        input.block()
        this.add(input, grid)
        inputs[input.name] = input
    }

    /**
     * Adds a QPasswordField to the form and applies the specified configuration.
     * @param block a function that takes a QPasswordField instance and applies the configuration.
     * @return the created QPasswordField object.
     */
    fun passwordInput(id: String, block: QPasswordField.() -> Unit)
    {
        require(id !in passwords) {"id \"$id\" already used"}
        val password = QPasswordField()
        password.name
        grid.clean()
        password.block()
        this.add(password, grid)
        passwords[password.name] = password
    }

    /**
     * Adds a QCheckBox to the form and applies the specified configuration.
     * @param block a function that takes a QCheckBox instance and applies the configuration.
     * @return the created QCheckBox object.
     */
    fun checkbox(id: String, block: QCheckBox.() -> Unit)
    {
        require(id !in checkButtons) {"id \"$id\" already used"}
        val input = QCheckBox()
        input.name = id
        grid.clean()
        input.block()
        this.add(input, grid)
        checkButtons[input.name] = input
    }

    /**
     * Adds a QRadioButton to the form and applies the specified configuration.
     * @param block a function that takes a QRadioButton instance and applies the configuration.
     * @return the created QRadioButton object.
     */
    fun radioButton(id: String, block: QRadioButton.() -> Unit)
    {
        require(id !in radioButtons) {"id \"$id\" already used"}
        val input = QRadioButton()
        input.name = id
        grid.clean()
        input.block()
        this.add(input, grid)
        radioButtons[input.name] = input
    }

    /**
     * Adds a QButton to the form with the specified text and applies the specified configuration.
     * @param text the text to display on the button.
     * @param block a function that takes a QButton instance and applies the configuration.
     */
    fun button(id: String, text: String,block: QButton.() -> Unit)
    {
        require(id !in buttons) {"id \"$id\" already used"}
        val btn = QButton(text)
        btn.name = id
        grid.clean()
        btn.block()
        this.add(btn,grid)
        buttons[btn.name] = btn
    }

    /**
     * Creates and adds a new instance of QComboBox to the QForm panel, and applies the properties defined in the given
     * block to the component. The QComboBox allows users to select one item from a dropdown list.
     * @param block a lambda expression that sets the properties of the QComboBox using a QComboBox builder object.
     * @return the newly created and added QComboBox instance.
     */
    fun<T> comboBox(id: String, block: QComboBox<T>.() -> Unit): QComboBox<T>
    {
        val combo = QComboBox<T>()
        combo.name = id
        grid.clean()
        combo.block()
        this.add(combo,grid)
        return combo
    }

    fun getLabels(id: String): JLabel? {
        return this.labels[id]
    }

    fun getInputText(id: String): JTextField? {
        return this.inputs[id]
    }

    fun getInputPassword(id: String): JPasswordField? {
        return this.passwords[id]
    }

    fun getButton(id: String): JButton? {
        return this.buttons[id]
    }

    fun getRadioButton(id: String): JRadioButton? {
        return this.radioButtons[id]
    }

    fun getCheckButton(id: String): JCheckBox? {
        return this.checkButtons[id]
    }
}