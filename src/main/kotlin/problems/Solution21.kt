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
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null || l2 == null) {
        return l1 ?: l2
    }

    var i = l1
    var j = l2
    val result = ListNode(0)
    var now: ListNode = result
    while (i != null || j != null) {
        if (i == null) {
            now.next = j
            break
        }
        if (j == null) {
            now.next = i
            break
        }
        if (i.`val`<= j.`val`) {
            val tmp = ListNode(i.`val`)
            now.next = tmp
            now = tmp
            i = i.next
        } else {
            val tmp = ListNode(j.`val`)
            now.next = tmp
            now = tmp
            j = j.next
        }
    }
    return result.next
}
