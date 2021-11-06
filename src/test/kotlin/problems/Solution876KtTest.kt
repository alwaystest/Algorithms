package problems

import org.junit.Test
import shouldBe

class Solution876KtTest {

    @Test
    fun middleNode_null_returnNull() {
        middleNode(null) shouldBe null
    }

    @Test
    fun middleNode_singleNode_returnHead() {
        middleNode(createLinkedList(1))!!.`val` shouldBe 1
    }

    @Test
    fun middleNode_twoNode_returnSecond() {
        middleNode(createLinkedList(1, 2))!!.`val` shouldBe 2
    }

    @Test
    fun middleNode_multiNode_returnSecondMiddle() {
        middleNode(createLinkedList(1, 2, 3))!!.`val` shouldBe 2
        middleNode(createLinkedList(1, 2, 3, 4))!!.`val` shouldBe 3
        middleNode(createLinkedList(1, 2, 3, 4, 5))!!.`val` shouldBe 3
    }
}
