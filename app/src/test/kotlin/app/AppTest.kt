/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package app

import org.junit.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test
    fun appHasList() {
        val app = App()
        assertNotNull(app.printList(), "app should have a list")
    }
}
