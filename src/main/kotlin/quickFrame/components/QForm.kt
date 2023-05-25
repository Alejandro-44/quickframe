package quickFrame.components

import java.awt.GridBagConstraints
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
    /*
    * Constants
    * */
    val horizontal = GridBagConstraints.HORIZONTAL
    val vertical = GridBagConstraints.VERTICAL

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
     * The QGridConstraints instance used to specify the position and size of components in the form.
     */
    val grid = QGridConstraints()

    /*
    * Maps of components
    * */
    private val labels = mutableMapOf<String, JLabel>()
    private val inputs = mutableMapOf<String, JTextField>()
    private val passwords = mutableMapOf<String, JPasswordField>()
    private val buttons = mutableMapOf<String, JButton>()
    private val checkButtons = mutableMapOf<String, JCheckBox>()
    private val radioButtons = mutableMapOf<String, JRadioButton>()


    /**
     * Retrieves the label associated with the given ID.
     *
     * @param id The ID of the label to retrieve.
     * @return The label (JLabel) associated with the provided ID, or null if no label with that ID is found.
     */
    fun getLabels(id: String): JLabel? {
        return this.labels[id]
    }

    /**
     * Retrieves the input text field associated with the given ID.
     *
     * @param id The ID of the input text field to retrieve.
     * @return The input text field (JTextField) associated with the provided ID, or null if no text field with that ID is found.
     */
    fun getInputText(id: String): JTextField? {
        return this.inputs[id]
    }

    /**
     * Retrieves the password field associated with the given ID.
     *
     * @param id The ID of the password field to retrieve.
     * @return The password field (JPasswordField) associated with the provided ID, or null if no password field with that ID is found.
     */
    fun getInputPassword(id: String): JPasswordField? {
        return this.passwords[id]
    }

    /**
     * Retrieves the button associated with the given ID.
     *
     * @param id The ID of the button to retrieve.
     * @return The button (JButton) associated with the provided ID, or null if no button with that ID is found.
     */
    fun getButton(id: String): JButton? {
        return this.buttons[id]
    }

    /**
     * Retrieves the radio button associated with the given ID.
     *
     * @param id The ID of the radio button to retrieve.
     * @return The radio button (JRadioButton) associated with the provided ID, or null if no radio button with that ID is found.
     */
    fun getRadioButton(id: String): JRadioButton? {
        return this.radioButtons[id]
    }

    /**
     * Retrieves the checkbox associated with the given ID.
     *
     * @param id The ID of the checkbox to retrieve.
     * @return The checkbbox (JCheckBox) associated with the provided ID, or null if no check box with that ID is found.
     */
    fun getCheckButton(id: String): JCheckBox? {
        return this.checkButtons[id]
    }

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
     *
     * @param id The unique identifier for the QLabel.
     * @param block A function that takes a QLabel instance and applies the configuration.
     * @return The created QLabel object.
     */
    fun label(id: String, block: QLabel.() -> Unit)
    {
        require(id !in labels) {"id \"$id\" already used"}
        val lab = QLabel("")
        lab.name = id
        labels[lab.name] = lab
        grid.clean()
        lab.block()
        this.add(lab, grid)
    }

    /**
     * Adds a QTextField to the form and applies the specified configuration.
     *
     * @param id The unique identifier for the QTextField.
     * @param block A function that takes a QTextField instance and applies the configuration.
     * @return The created QTextField object.
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
     *
     * @param id The unique identifier for the QPasswordField.
     * @param block A function that takes a QPasswordField instance and applies the configuration.
     * @return The created QPasswordField object.
     */
    fun passwordInput(id: String, block: QPasswordField.() -> Unit)
    {
        require(id !in passwords) {"id \"$id\" already used"}
        val password = QPasswordField()
        password.name = id
        grid.clean()
        password.block()
        this.add(password, grid)
        passwords[password.name] = password
    }

    /**
     * Adds a QCheckBox to the form and applies the specified configuration.
     *
     * @param id The unique identifier for the QCheckBox.
     * @param block A function that takes a QCheckBox instance and applies the configuration.
     * @return The created QCheckBox object.
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
     * Adds a [QRadioButton] to the form and applies the specified configuration.
     *
     * @param id The unique identifier for the [QRadioButton].
     * @param block A function that takes a [QRadioButton] instance and applies the configuration.
     * @return The created QRadioButton object.
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
     * Adds a [QButton] to the form with the specified text and applies the specified configuration.
     *
     * @param id The unique identifier for the [QButton].
     * @param block A function that takes a [QButton] instance and applies the configuration.
     */
    fun button(id: String,block: QButton.() -> Unit)
    {
        require(id !in buttons) {"id \"$id\" already used"}
        val btn = QButton()
        btn.name = id
        grid.clean()
        btn.block()
        this.add(btn,grid)
        buttons[btn.name] = btn
    }

    /**
     * Creates and adds a new instance of QComboBox to the QForm panel, and applies the properties defined in the given block
     * to the component. The QComboBox allows users to select one item from a dropdown list.
     *
     * @param id The unique identifier for the QComboBox.
     * @param block A lambda expression that sets the properties of the QComboBox using a QComboBox builder object.
     * @return The newly created and added QComboBox instance.
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
}