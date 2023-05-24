package quickFrame.components

import java.awt.GridLayout
import javax.swing.JPanel

class QFormsGroup(
    rows: Int,
    cols: Int,
    hgap: Int,
    vgap: Int): JPanel() {

    init {
        this.layout = GridLayout(rows, cols, hgap, vgap)
    }

    /**
     * An instance of [QComponentBuilder] to apply properties to this [QComboBox].
     */
    private val builder = QComponentBuilder()

    /**
     * Applies a [block] of [QComponentBuilder] properties to this [QComboBox].
     * @param block a lambda expression with a receiver of type [QComponentBuilder].
     */
    fun properties(block: QComponentBuilder.(QFormsGroup) -> Unit) {
        builder.block(this)
    }

}