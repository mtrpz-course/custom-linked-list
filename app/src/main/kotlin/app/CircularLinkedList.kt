package app

class CircularLinkedList : List {

    private data class Node(
        var element: Char,
        var next: Node? = null,
    )

    private var head: Node? = null

    private var length: Int = 0

    override fun length(): Int {
        TODO("Not yet implemented")
    }

    override fun append(element: Char) {
        TODO("Not yet implemented")
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
