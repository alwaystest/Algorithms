package problems

import org.junit.Test
import shouldBe

class Solution661Test {

    @Test
    fun imageSmoother_always_verifyResults() {
        val array = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        val expect = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )

        val result = imageSmoother(array)

        verifyResult(result, expect)
    }

    private fun verifyResult(result: Array<IntArray>, expect: Array<IntArray>) {
        for (x in result.indices) {
            for (y in result[x].indices) {
                result[x][y] shouldBe expect[x][y]
            }
        }
    }

    @Test
    fun isValid_always_verifyResult() {
        val array = arrayOf(
            intArrayOf(1)
        )

        val invalid = listOf(
            isValid(array, -1, -1),
            isValid(array, -1, 0),
            isValid(array, -1, 1),
            isValid(array, 0, -1),
            isValid(array, 0, 1),
            isValid(array, 1, -1),
            isValid(array, 1, 0),
            isValid(array, 1, 1)
        )
        val valid = isValid(array, 0, 0)

        invalid.any { it } shouldBe false
        valid shouldBe true
    }

    @Test
    fun getNeighbors_noNeighbor_verifyResult() {
        val array = arrayOf(
            intArrayOf(1)
        )

        val neighbors = getNeighbors(array, 0, 0)

        neighbors.isEmpty() shouldBe true
    }

    @Test
    fun getNeighbors_oneLine_verifyResult() {
        val array = arrayOf(
            intArrayOf(1, 2)
        )

        val neighbors = getNeighbors(array, 0, 0)

        neighbors.size shouldBe 1
        neighbors[0] shouldBe 2
    }

    @Test
    fun getAverage_onNeighbor_shouldBeSelf() {
        val array = arrayOf(
            intArrayOf(1)
        )

        val avg = getAverage(array, 0, 0)

        avg shouldBe 1
    }

    @Test
    fun getAverage_oneLine_shouldBeSelf() {
        val array = arrayOf(
            intArrayOf(1, 3)
        )

        val avg = getAverage(array, 0, 0)

        avg shouldBe 2
    }
}