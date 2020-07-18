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

}