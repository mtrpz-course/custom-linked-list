package app

import org.junit.Test
import kotlin.test.assertEquals

class CircularLinkedListTest {
    @Test
    fun testToString() {
        val list = CircularLinkedList()
        assertEquals("", list.toString(), "list should be empty")
        list.append('a')
        assertEquals("a", list.toString(), "list should be \"a\" ")
    }

    @Test
    fun testLength() {
        val list = CircularLinkedList()
        assertEquals(0, list.length(), "list should be empty")
        list.append('a')
        assertEquals(1, list.length(), "list should have one element")
        list.append('b')
        assertEquals(2, list.length(), "list should have two elements")
    }

    @Test
    fun testAppend() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        assertEquals("abc", list.toString(), "list should be \"abc\" ")
    }
}
