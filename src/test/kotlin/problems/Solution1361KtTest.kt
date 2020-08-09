package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution1361KtTest {

    @Test
    fun validateBinaryTreeNodes_example1_valid() {
        val result = validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, -1, -1, -1))
        result shouldBe true
    }

    @Test
    fun validateBinaryTreeNodes_example2_invalid() {
        val result = validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, 3, -1, -1))
        result shouldBe false
    }

    @Test
    fun validateBinaryTreeNodes_example3_invalid() {
        val result = validateBinaryTreeNodes(2, intArrayOf(1, 0), intArrayOf(-1, -1))
        result shouldBe false
    }

    @Test
    fun validateBinaryTreeNodes_example4_invalid() {
        val result = validateBinaryTreeNodes(6, intArrayOf(1, -1, -1, 4, -1, -1), intArrayOf(2, -1, -1, 5, -1, -1))
        result shouldBe false
    }
}