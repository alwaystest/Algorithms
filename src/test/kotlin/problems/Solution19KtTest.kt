package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution19KtTest {

    @Test
    fun removeNthFromEnd_0_returnRaw() {
        val data = createLinkedList(1, 2, 3)

        val result = removeNthFromEnd(data, 0)

        data.toStr() shouldBe result?.toStr()
    }

    @Test
    fun removeNthFromEnd_removeLast_verify() {
        val data = createLinkedList(1, 2, 3)
        val expect = createLinkedList(1, 2)

        val result = removeNthFromEnd(data, 1)

        expect.toStr() shouldBe result?.toStr()
    }

    @Test
    fun removeNthFromEnd_removeNotExist_verify() {
        val data = createLinkedList(1, 2, 3)
        val expect = createLinkedList(1, 2, 3)

        val result = removeNthFromEnd(data, 4)

        expect.toStr() shouldBe result?.toStr()
    }

    @Test
    fun removeNthFromEnd_removeFirst_verify() {
        val data = createLinkedList(1, 2, 3)
        val expect = createLinkedList(2, 3)

        val result = removeNthFromEnd(data, 3)

        expect.toStr() shouldBe result?.toStr()
    }
}
