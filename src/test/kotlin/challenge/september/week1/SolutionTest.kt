package challenge.september.week1

import org.junit.Assert.*
import org.junit.Test
import shouldBe
import java.util.*

class SolutionTest {

    @Test
    fun getOrder_root1_verify() {
        val n1 = TreeNode(1)
        val n2 = TreeNode(2)
        val n3 = TreeNode(3)
        n1.right = n2
        n2.right = n3
        Solution().getOrder(n1) shouldBe listOf(1, 2, 3)
    }

    @Test
    fun getOrder_root2_verify() {
        val n1 = TreeNode(1)
        val n2 = TreeNode(2)
        val n3 = TreeNode(3)
        n2.left = n1
        n2.right = n3
        Solution().getOrder(n2) shouldBe listOf(1, 2, 3)
    }

    @Test
    fun getOrder_root3_verify() {
        val n1 = TreeNode(1)
        val n2 = TreeNode(2)
        val n3 = TreeNode(3)
        n3.left = n2
        n2.left = n1
        Solution().getOrder(n3) shouldBe listOf(1, 2, 3)
    }

    @Test
    fun merge_firstEmpty_verify() {
        val l1 = LinkedList<Int>()
        val l2 = LinkedList<Int>().also {
            it.addAll(listOf(1, 2, 3))
        }
        Solution().merge(l1, l2) shouldBe listOf(1, 2, 3)
    }

    @Test
    fun merge_secondEmpty_verify() {
        val l1 = LinkedList<Int>()
        val l2 = LinkedList<Int>().also {
            it.addAll(listOf(1, 2, 3))
        }
        Solution().merge(l2, l1) shouldBe listOf(1, 2, 3)
    }

    @Test
    fun merge_notEmpty_verify() {
        val l1 = LinkedList<Int>().also {
            it.addAll(listOf(1, 2, 3))
        }
        val l2 = LinkedList<Int>().also {
            it.addAll(listOf(1, 2, 3))
        }
        Solution().merge(l1, l2) shouldBe listOf(1, 1, 2, 2, 3, 3)
    }
}