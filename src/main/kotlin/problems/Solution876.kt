package problems

fun middleNode(head: ListNode?): ListNode? {
    head ?: return head
    head.next ?: return head
    val dummy = ListNode(0).also { it.next = head }
    var first: ListNode? = dummy
    var second: ListNode = dummy
    while(true) {
        first ?: break
        first = first.next?.next
        second = second.next!!
    }
    return second
}
