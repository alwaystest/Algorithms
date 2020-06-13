package problem239

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import shouldBe

private fun case(data: IntArray, windowSize: Int, expect: IntArray) = arrayOf(data, windowSize, expect)

@RunWith(Parameterized::class)
class Solution239KtTest(private val data: IntArray, private val windowSize: Int, private val expect: IntArray) {

    companion object {

        @Parameterized.Parameters
        @JvmStatic
        fun params() = listOf(
            case(intArrayOf(1, 2, 3), 1, intArrayOf(1, 2, 3)),
            case(intArrayOf(3, 2, 1), 1, intArrayOf(3, 2, 1)),
            case(intArrayOf(1, 2, 3), 2, intArrayOf(2, 3)),
            case(intArrayOf(1, 2, 3), 3, intArrayOf(3))
        )
    }

    @Test
    fun maxSlidingWindow_basicCase_verifyResult() {
        val result = maxSlidingWindow(data, windowSize)

        result shouldBe expect
    }
}