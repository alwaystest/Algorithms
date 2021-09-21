package problems

import org.junit.Test
import shouldBe

internal class Solution350KtTest {
    @Test
    fun intersect_sameArray_verifyResult() {
        val nums = intArrayOf(1, 2, 3)

        val result = intersect(nums, nums)

        result.all { nums.contains(it) } shouldBe true
    }

    @Test
    fun intersect_noIntersection_verifyResult() {
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(4)

        val result = intersect(nums1, nums2)

        result.size shouldBe 0
    }

    @Test
    fun intersect_oneEmptyArray_verifyResult() {
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf()

        val result = intersect(nums1, nums2)

        result.size shouldBe 0
    }

    @Test
    fun intersect_emptyArrays_verifyResult() {
        val nums1 = intArrayOf()
        val nums2 = intArrayOf()

        val result = intersect(nums1, nums2)

        result.size shouldBe 0
    }

    @Test
    fun intersect_intersectionExist_verifyResult() {
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(2, 3)

        val result = intersect(nums1, nums2)

        result.all { nums2.contains(it) } shouldBe true
    }
}