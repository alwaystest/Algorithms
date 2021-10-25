package problems

import java.util.*
import kotlin.random.Random

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution(private val head: ListNode?) {

    var size = if (head == null) 0 else 1

     init {
         var p = head
         while (p?.next != null) {
             size++
             p = p.next
         }
     }

    /** Returns a random node's value. */
    fun getRandom(): Int {
        var p:ListNode = head ?: return -1
        var n = Random.nextInt(size)
        while (n-- != 0) {
            p = p.next!!
        }
        return p.`val`
    }

}

