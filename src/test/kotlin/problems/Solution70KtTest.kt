package problems

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import shouldBe

@RunWith(Parameterized::class)
class Solution70KtTest(private val n: Int, private val result: Int) {

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun params() = listOf(
            arrayOf(1, 1),
            arrayOf(2, 2),
            arrayOf(3, 3),
            arrayOf(4, 5),
            arrayOf(5, 8)
        )
    }

    @Test
    fun climbStairs_always_verifyResult() {
        climbStairs(n) shouldBe result
    }

}
