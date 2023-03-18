package app

class CircularLinkedList : List {
    inner class Node(
        var element: Char,
        var next: Node? = null,
    )

    var head: Node? = null

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
        if (index < 0 || index >= length) {
            throw IndexOutOfBoundsException()
        }
        var current = head
        for (i in 0 until index) {
            current = current?.next
        }
        return current!!.element
    }

    override fun clone(): List {
        val newList = CircularLinkedList()
        var current = head
        for (i in 0 until length) {
            newList.append(current?.element!!)
            current = current.next
        }
        return newList
    }

    override fun reverse() {
        var prev: Node? = null
        var current = head
        var next: Node? = null
        do {
            next = current?.next
            current?.next = prev
            prev = current
            current = next
        } while (current != head)
        head?.next = prev
        head = prev
    }

    override fun findFirst(element: Char): Int {
        var current = head
        var index = 0
        var count = 0
        while (current != null && count < length) {
            if (current.element == element) {
                return index
            }
            current = current.next
            index++
            count++
        }
        return -1
    }

    override fun findLast(element: Char): Int {
        var current = head
        var index = 0
        var count = 0
        var lastIndex = -1
        while (current != null && count < length) {
            if (current.element == element) {
                lastIndex = index
            }
            current = current.next
            index++
            count++
        }
        return lastIndex
    }

    override fun clear() {
        head = null
        length = 0
    }

    override fun extend(elements: List) {
        for (i in 0 until elements.length()) {
            append(elements.get(i))
        }
    }
}
