package problems

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode.toStr(): String {
    val result = mutableListOf<Int>()
    var node: ListNode? = this
    while (node != null) {
        result.add(node.`val`)
        node = node.next
    }
    return result.joinToString(",")
}

fun createLinkedList(vararg arrays: Int): ListNode {
    require(arrays.isNotEmpty())
    return ListNode(arrays[0]).also {
        var tail = it
        for (i in 1 .. arrays.lastIndex) {
            tail.next = ListNode(arrays[i])
            tail = tail.next!!
        }
    }
}

