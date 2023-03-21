package app

import java.util.LinkedList

class CircularLinkedList() : List<Char> {
    inner class Node(
        var element: Char,
        var next: Node? = null,
    )
    var head: Node? = null
    private val baseList = LinkedList<Node>()

    override fun toString(): String {
        var string = ""
        for (i in baseList.indices) {
            string += baseList[i].element
        }
        return string
    }

    override fun length(): Int {
        return baseList.size
    }

    override fun append(element: Char) {
        if (head == null) {
            baseList.add(Node(element))
            head = baseList.first
        } else if (baseList.size == 1) {
            baseList.add(Node(element))
            baseList[0].next = baseList[1]
            baseList[1].next = baseList[0]
        } else {
            baseList.add(Node(element))
            baseList[baseList.size - 2].next = baseList[baseList.size - 1]
            baseList[baseList.size - 1].next = baseList[0]
        }
    }

    override fun insert(element: Char, index: Int) {
        if (index < 0 || index >= baseList.size) {
            throw IndexOutOfBoundsException()
        }
        val newNode = Node(element, baseList[index])
        when (index) {
            0 -> {
                baseList[baseList.size - 1].next = newNode
                head = newNode
                baseList.add(index, newNode)
            }
            1 -> {
                baseList[0].next = newNode
                head?.next = newNode
                baseList.add(index, newNode)
            }

            else -> {
                baseList[index - 1].next = newNode
                baseList[index].next = newNode
                baseList.add(index, newNode)
            }
        }
    }

    override fun delete(index: Int): Char {
        if (index < 0 || index >= baseList.size) {
            throw IndexOutOfBoundsException()
        }
        var deletedChar: Char = ' '
        var current = head
        when (index) {
            0 -> {
                deletedChar = head?.element ?: deletedChar
                while (current?.next != head) {
                    current = current?.next
                }
                current?.next = head?.next
                head = head?.next
                baseList.removeAt(index)
            }

            else -> {
                for (i in 0 until index - 1) {
                    current = current?.next
                }
                deletedChar = current?.next?.element ?: deletedChar
                current?.next = current?.next?.next
                baseList.removeAt(index)
            }
        }
        return deletedChar
    }

    override fun deleteAll(element: Char) {
        for (i in baseList.indices.reversed()) {
            if (baseList[i].element == element) {
                baseList.removeAt(i)
                if (i == 0) {
                    head = baseList.first
                }
            }
        }
        for (i in 0 until baseList.size - 1) {
            baseList[i].next = baseList[i + 1]
        }
    }

    override fun get(index: Int): Char {
        if (index < 0 || index >= baseList.size) {
            throw IndexOutOfBoundsException()
        }
        return baseList[index].element
    }

    override fun clone(): CircularLinkedList {
        val newList = CircularLinkedList()
        for (i in baseList.indices) {
            newList.append(baseList[i].element)
        }
        return newList
    }

    override fun reverse() {
        baseList.reverse()
        head = baseList.first
        for (i in 0 until baseList.size - 1) {
            baseList[i].next = baseList[i + 1]
        }
    }

    override fun findFirst(element: Char): Int {
        for (i in baseList.indices) {
            if (baseList[i].element == element) {
                return i
            }
        }
        return -1
    }

    override fun findLast(element: Char): Int {
        for (i in baseList.indices.reversed()) {
            if (baseList[i].element == element) {
                return i
            }
        }
        return -1
    }

    override fun clear() {
        baseList.clear()
        head = null
    }

    override fun extend(elements: CircularLinkedList) {
        for (i in elements.baseList.indices) {
            baseList.add(elements.baseList[i])
        }
    }
}
