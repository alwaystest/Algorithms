package problems

import org.junit.*
import shouldBe

class Solution141KtTest {

    @Test
    fun hasCycle_null_returnFalse() {
        hasCycle(null) shouldBe false
    }

    @Test
    fun hasCycle_noCycle_returnFalse() {
        hasCycle(createLinkedList(1, 2, 3)) shouldBe false
    }

    @Test
    fun hasCycle_hasCycle_returnTrue() {
        val head = createLinkedList(1)
        head.next = head
        hasCycle(head) shouldBe true
    }

    @Test
    fun hasCycle_hasCycle1_returnTrue() {
        val head = createLinkedList(1)
        head.next = createLinkedList(2)
        head.next?.next = head
        hasCycle(head) shouldBe true
    }
}
