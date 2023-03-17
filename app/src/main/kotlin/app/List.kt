package app

interface List {
    fun length(): Int
    fun append(element: Char)
    fun insert(element: Char, index: Int)
    fun delete(index: Int): Char
    fun deleteAll(element: Char)
    fun get(index: Int): Char
    fun clone(): List
    fun reverse()
    fun findFirst(element: Char): Int
    fun findLast(element: Char): Int
    fun clear()
    fun extend(elements: List)
}
