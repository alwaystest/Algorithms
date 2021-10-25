package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution23KtTest {

    @Test
    fun metgeKLists_emptyArray_returnNull() {
        mergeKLists(emptyArray()) shouldBe null
    }

    @Test
    fun metgeKLists_oneemptyArray_returnNull() {
        mergeKLists(arrayOf<ListNode?>(null)) shouldBe null
    }

    @Test
    fun metgeKLists_oneElementArray_returnFirstArray() {
        mergeKLists(arrayOf(createLinkedList(1, 2, 3)))!!.toStr() shouldBe createLinkedList(1, 2, 3).toStr()
    }

    @Test
    fun mergeKLists_notNullOrEmpty_returnSortedResult() {
        mergeKLists(arrayOf(createLinkedList(1, 2, 3), createLinkedList(2, 3, 4)))!!.toStr() shouldBe createLinkedList(1, 2, 2, 3, 3, 4).toStr()
    }

    @Test
    fun mergeKLists_sample1_returnSortedResult() {
        mergeKLists(arrayOf(createLinkedList(-2, -1, -1, -1), null))!!.toStr() shouldBe createLinkedList(-2, -1, -1, -1).toStr()
    }

}
