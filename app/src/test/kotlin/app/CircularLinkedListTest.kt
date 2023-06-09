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
    fun testNextNode() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        assertEquals('a', list.head?.element, "next node should be \'a\'")
        assertEquals('b', list.head?.next?.element, "next node should be \'b\'")
        assertEquals('c', list.head?.next?.next?.element, "next node should be \'c\'")
        assertEquals('a', list.head?.next?.next?.next?.element, "next node should be \'a\'")
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

    @Test
    fun testInsert() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        list.insert('d', 1)
        assertEquals("adbc", list.toString(), "list should be \"adbc\" ")
        list.insert('e', 0)
        assertEquals("eadbc", list.toString(), "list should be \"eadbc\" ")
        list.insert('f', 4)
        assertEquals("eadbfc", list.toString(), "list should be \"eadbfc\" ")
    }

    @Test
    fun testDelete() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')
        list.append('e')
        assertEquals('a', list.delete(0), "list should be \"bcde\" ")
        assertEquals('e', list.delete(3), "list should be \"bcd\" ")
        assertEquals('c', list.delete(1), "list should be \"bd\" ")
    }

    @Test
    fun testDeleteAll() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('b')
        list.append('c')
        list.append('b')
        list.deleteAll('b')
        assertEquals("ac", list.toString(), "list should be \"ac\" ")
    }

    @Test
    fun testGet() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')
        list.append('e')
        assertEquals('a', list.get(0), "element should be \'a\' ")
        assertEquals('e', list.get(4), "element should be \'e\' ")
        assertEquals('c', list.get(2), "element should be \'c\' ")
    }

    @Test
    fun testClone() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')
        list.append('e')
        val clone = list.clone()
        assertEquals(list.toString(), clone.toString(), "clone should be \"abcde\" ")
    }

    @Test
    fun testReverse() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        list.reverse()
        assertEquals("cba", list.toString(), "list should be \"cba\" ")
    }

    @Test
    fun testFindFirst() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('b')
        list.append('b')
        list.append('e')
        assertEquals(1, list.findFirst('b'), "element should be at index 0")
    }

    @Test
    fun testFindLast() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('b')
        list.append('b')
        list.append('c')
        assertEquals(3, list.findLast('b'), "element should be at index 1")
    }

    @Test
    fun testClear() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        list.append('d')
        list.append('e')
        list.clear()
        assertEquals(0, list.length(), "list should be empty")
    }

    @Test
    fun testExtend() {
        val list = CircularLinkedList()
        list.append('a')
        list.append('b')
        list.append('c')
        val list2 = CircularLinkedList()
        list2.append('d')
        list2.append('e')
        list.extend(list2)
        assertEquals("abcde", list.toString(), "list should be \"abcde\" ")
    }
}
