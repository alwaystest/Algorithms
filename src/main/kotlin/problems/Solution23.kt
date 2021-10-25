package problems

import java.util.PriorityQueue

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.size == 0) {
        return null
    }
    if (lists.size == 1) {
        return lists[0]
    }
    val queue = PriorityQueue<ListNode>(compareBy { it.`val` })
    val dummy = ListNode(-1)
    for (node in lists) {
        node?.let { queue.add(it) }
    }
    var current = dummy
    while(queue.isNotEmpty()) {
        val n = queue.poll()
        current.next = n
        current = n
        n.next?.let { queue.add(it) }
    }
    return dummy.next
}

