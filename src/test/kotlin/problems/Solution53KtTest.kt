package problems

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import shouldBe

@RunWith(Parameterized::class)
class Solution53KtTest(private val array: IntArray, private val result: Int) {

    companion object {

        private fun case(array: IntArray, result: Int) = arrayOf(array, result)

        @JvmStatic
        @Parameterized.Parameters
        fun params() = listOf(
            case(intArrayOf(1), 1),
            case(intArrayOf(-1), -1),
            case(intArrayOf(-2147483647), -2147483647),
            case(intArrayOf(-1, 1), 1),
            case(intArrayOf(1, 2, 3), 6),
            case(intArrayOf(-1, 1, -2, 3), 3),
            case(intArrayOf(-1, 5, -1, 2), 6),
            case(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6)
        )
    }

    @Test
    fun maxSubArray_examples_verify() {
        maxSubArray(array).shouldBe(result) { "${array.joinToString()} should return $result" }
    }
}