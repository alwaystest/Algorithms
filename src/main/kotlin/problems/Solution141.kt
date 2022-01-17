package problems

fun hasCycle(head: ListNode?): Boolean {
    head?: return false
    var first: ListNode? = head
    var second: ListNode? = head.next
    while(second != null) {
        if (second == first) return true
        first = first?.next
        second = second.next?.next
    }
    return false
}
