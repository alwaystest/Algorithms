package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution199KtTest {

    @Test
    fun rightSideView_null_returnEmptyList() {
        val result = rightSideView(null)
        result.size shouldBe 0
    }

    @Test
    fun rightSideView_oneNode_returnRoot() {
        val result = rightSideView(TreeNode(1))

        (result == listOf(1)) shouldBe true
    }

    @Test
    fun rightSideView_twoNodes_verifyResult() {
        val root = TreeNode(1)
        root.left = TreeNode(2)

        val result = rightSideView(root)

        (result == listOf(1, 2)) shouldBe true
    }

    @Test
    fun rightSideView_threeNodes_verifyResult() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        val result = rightSideView(root)

        (result == listOf(1, 3)) shouldBe true
    }

    @Test
    fun rightSideView_threeNodesLeft_verifyResult() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.left?.left = TreeNode(3)

        val result = rightSideView(root)

        (result == listOf(1, 2, 3)) shouldBe true
    }

}