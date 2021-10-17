package problem2

import org.junit.Test
import shouldBe

class Solution2KtTest() {

    @Test
    fun addTwoNumbers_case1_verify() {
        addTwoNumbers(ListNode(0), ListNode(0))?.`val` shouldBe 0
        addTwoNumbers(ListNode(1), ListNode(1))?.`val` shouldBe 2
    }


    @Test
    fun addTwoNumbers_case2_verify() {
        val result= addTwoNumbers(ListNode(5), ListNode(5))
        result?.`val` shouldBe 0
        result?.next?.`val` shouldBe 1
    }
}
