package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution21KtTest {

    @Test
    fun mergeTwoLists_firstNullOrEmpty_returnSecond() {
        mergeTwoLists(null, ListNode(1))!!.toStr() shouldBe ListNode(1).toStr()
    }

    @Test
    fun mergeTwoLists_secondNullOrEmpty_returnFirst() {
        mergeTwoLists(ListNode(1), null)!!.toStr() shouldBe ListNode(1).toStr()
    }

    @Test
    fun mergeTwoLists_bothNullOrEmpty_returnNull() {
        mergeTwoLists(null, null) shouldBe null
    }

    @Test
    fun mergeTwoLists_notNullOrEmpty_returnSortedResult() {
        mergeTwoLists(createData(1, 2, 3), createData(2, 3, 4))!!.toStr() shouldBe createData(1, 2, 2, 3, 3, 4).toStr()
    }

    private fun createData(vararg arrays: Int): ListNode {
        require(arrays.isNotEmpty())
        return ListNode(arrays[0]).also {
            var tail = it
            for (i in 1 .. arrays.lastIndex) {
                tail.next = ListNode(arrays[i])
                tail = tail.next!!
            }
        }
    }
}
