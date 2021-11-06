package problems

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (n == 0 || head == null) return head

    val dummy = ListNode(0)
    dummy.next = head
    var first: ListNode? = dummy
    for(i in 0 until n) {
        first = first?.next
        first ?: return dummy.next
    }
    var second: ListNode = dummy
    while(first?.next != null) {
        first = first.next
        second = second.next!!
    }
    second.next = second.next!!.next

    return dummy.next
}
