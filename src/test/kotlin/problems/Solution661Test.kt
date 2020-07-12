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
}