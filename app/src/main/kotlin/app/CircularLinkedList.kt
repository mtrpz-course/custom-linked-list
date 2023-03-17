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
        if (index < 0 || index >= length) {
            throw IndexOutOfBoundsException()
        }
        when (index) {
            0 -> {
                val newNode = Node(element, head)
                var current = head
                while (current?.next != head) {
                    current = current?.next
                }
                current?.next = newNode
                head = newNode
                length++
            }
            else -> {
                var current = head
                for (i in 0 until index - 1) {
                    current = current?.next
                }
                val newNode = Node(element, current?.next)
                current?.next = newNode
                length++
            }
        }
    }

    override fun delete(index: Int): Char {
        if (index < 0 || index >= length) {
            throw IndexOutOfBoundsException()
        }
        var deletedChar: Char = ' '
        when (index) {
            0 -> {
                deletedChar = head?.element ?: deletedChar
                var current = head
                while (current?.next != head) {
                    current = current?.next
                }
                current?.next = head?.next
                head = head?.next
                length--
            }

            else -> {
                var current = head
                for (i in 0 until index - 1) {
                    current = current?.next
                }
                deletedChar = current?.next?.element ?: deletedChar
                current?.next = current?.next?.next
                length--
            }
        }
        return deletedChar
    }

    override fun deleteAll(element: Char) {
        var current = head
        var prev: Node? = null
        var count = 0
        while (current != null && count <= length) {
            if (current.element == element) {
                if (current == head) {
                    head = current.next
                } else {
                    prev?.next = current.next
                    current = current.next
                }
                length--
            } else {
                prev = current
                current = current.next
            }
            count++
        }
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
