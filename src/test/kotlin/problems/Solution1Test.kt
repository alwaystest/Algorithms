package problems

import Solution1
import org.junit.Test
import shouldBe

class Solution1Test {
    @Test
    fun twoSum_cases_verify() {
        Solution1().twoSum(intArrayOf(1, 2, 3), 5) shouldBe intArrayOf(1, 2)
        Solution1().twoSum(intArrayOf(3, 3), 6) shouldBe intArrayOf(0, 1)
        Solution1().twoSum(intArrayOf(2, 7, 11, 15), 9) shouldBe intArrayOf(0, 1)
        Solution1().twoSum(intArrayOf(3, 2, 4), 6) shouldBe intArrayOf(1, 2)
    }
}
