package problems

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import shouldBe

@RunWith(Parameterized::class)
class Solution91KtTest(private val s: String, private val result: Int) {

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun params() = listOf(
            arrayOf("0", 0),
            arrayOf("1", 1),
            arrayOf("10", 1),
            arrayOf("11", 2),
            arrayOf("12", 2),
            arrayOf("226", 3),
            arrayOf("227", 2),
            arrayOf("1201234", 3),
            arrayOf("2101", 1)
        )
    }

    @Test
    fun numDecodings_params_verifyResult() {
        numDecodings(s) shouldBe result
    }
}
