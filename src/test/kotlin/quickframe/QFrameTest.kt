package quickframe

import org.junit.jupiter.api.Test
import quickframe.utils.buildFrame
import java.awt.Dimension

class QFrameTest {
    private val frame = buildFrame {
        properties {
            it title "FrameTest"
            it size Dimension(500, 600)
            it onClose EXIT
            it resizable true
        }
    }

    @Test
    fun buildFrameTest() {
        frame.isVisible = true
    }
}