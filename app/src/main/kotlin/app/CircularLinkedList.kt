package app

class CircularLinkedList : List {

    private data class Node(
        var element: Char,
        var next: Node? = null,
    )

    private var head: Node? = null

    private var length: Int = 0

    override fun toString(): String {
        var result = ""
        return if (head == null) {
            return result
        } else {
            var current = head
            while (current?.next != head) {
                result += current?.element
                current = current?.next
            }
            result += current?.element
            result
        }
    }

    override fun length(): Int {
        return length
    }

    override fun append(element: Char) {
        if (head == null) {
            head = Node(element)
            head?.next = head
        } else {
            var current = head
            while (current?.next != head) {
                current = current?.next
            }
            current?.next = Node(element, head)
        }
        length++
    }

    override fun insert(element: Char, index: Int) {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Char {
        TODO("Not yet implemented")
    }

    override fun deleteAll(element: Char) {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): Char {
        TODO("Not yet implemented")
    }

    override fun clone(): List {
        TODO("Not yet implemented")
    }

    override fun reverse() {
        TODO("Not yet implemented")
    }

    override fun findFirst(element: Char): Int {
        TODO("Not yet implemented")
    }

    override fun findLast(element: Char): Int {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun extend(elements: List) {
        TODO("Not yet implemented")
    }
}
