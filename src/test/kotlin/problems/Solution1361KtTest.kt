package problems

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

    @Test
    fun validateBinaryTreeNodes_circleCase_invalid() {
        val result = validateBinaryTreeNodes(4, intArrayOf(1, 2, 0, -1), intArrayOf(-1, -1, -1, -1))
        result shouldBe false
    }

    @Test
    fun validateBinaryTreeNodes_circleCase1_invalid() {
        val result = validateBinaryTreeNodes(2, intArrayOf(0, -1), intArrayOf(-1, -1))
        result shouldBe false
    }

    @Test
    fun validateBinaryTreeNodes_firstNotRoot_invalid() {
        val result = validateBinaryTreeNodes(2, intArrayOf(-1, 0), intArrayOf(-1, -1))
        result shouldBe true
    }

    @Test
    fun parentCountValid_count0_valid() {
        addParentCountAndValidate(0, intArrayOf(0)) shouldBe true
    }

    @Test
    fun parentCountValid_count1_invalid() {
        addParentCountAndValidate(0, intArrayOf(1)) shouldBe false
    }

    @Test
    fun parentCountValid_moreThan1_invalid() {
        addParentCountAndValidate(0, intArrayOf(2)) shouldBe false
    }

    @Test
    fun validateCircle_noCircle_valid() {
        validateCircle(0, intArrayOf(1, -1), intArrayOf(-1, -1), BooleanArray(2)) shouldBe true
    }

    @Test
    fun validateCircle_circle_invalid() {
        validateCircle(0, intArrayOf(1, 0), intArrayOf(-1, -1), BooleanArray(2)) shouldBe false
    }
}