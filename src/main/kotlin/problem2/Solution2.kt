package problem2

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    var n1 = l1
    var n2 = l2
    val head = ListNode(0)
    var currentNode = head
    var inc = 0
    while(n1 != null || n2 != null) {
        val newNode = ListNode(0)
        val cur = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + inc
        n1 = n1?.next
        n2 = n2?.next
        newNode.`val` = cur % 10
        inc = cur / 10
        currentNode.next = newNode
        currentNode = newNode
    }
    if (inc != 0) {
        currentNode.next = ListNode(inc)
    }
    return head.next
}
